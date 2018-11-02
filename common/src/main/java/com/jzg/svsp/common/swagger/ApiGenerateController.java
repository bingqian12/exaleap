package com.jzg.svsp.common.swagger;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.jzg.svsp.common.util.UUIDUtil;
import com.jzg.svsp.common.vo.ResultVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.reflections.ReflectionUtils;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger.web.ApiResourceController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/30 19:28
 * @notes:
 */
@RestController
@RequestMapping
@SuppressWarnings("all")
@Slf4j
@ConditionalOnExpression("'${swagger.enable:false}' == 'true'")
public class ApiGenerateController {
    @Value("${spring.application.name:}")
    private String serviceId;
    @Value("${server.port:80}")
    private String port;
    @Autowired
    private ApplicationContext applicationContext;

    private String doc = null;

    @GetMapping(value = "/api", produces = "text/plain")
    public String apiResponse() throws Exception {
        if (doc == null) {
            return getFeignClientString();
        }
        return doc;
    }

    @GetMapping
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    private String getFeignClientString() throws Exception {
        StringBuilder content = new StringBuilder();
        /*判断org.springframework.cloud.netflix.feign.FeignClient这个类是否存在*/
        try {
            Class.forName("org.springframework.cloud.netflix.feign.FeignClient");
            content.append(String.format("@FeignClient(\"%s\")\n", serviceId));
        } catch (ClassNotFoundException e) {
            String inetAddress = InetAddress.getLocalHost().getHostAddress();
            if (StringUtils.isEmpty(serviceId)) {
                serviceId = UUIDUtil.getRandomId();
            }
            content.append(String.format("@FeignClient(name = \"%s\",url = \"http://%s:%s\")\n", serviceId, inetAddress, port));
        }
        content.append("public interface DemoFeignClient {\n");
        Set<Class<?>> importClasses = Sets.newHashSet();
        importClasses.add(PostMapping.class);
        importClasses.add(ResultVo.class);
        getControllerClass().forEach(resourceClass -> {
                    log.info("class is {}", resourceClass);
                    // 获取类@requestMapping注解，取出前缀
                    String classPath = "";
                    RequestMapping classPathAnnotation = resourceClass.getAnnotation(RequestMapping.class);
                    if (classPathAnnotation != null) {
                        classPath = classPathAnnotation.value()[0];
                    }
                    Set<Method> methodSet = ReflectionUtils.getAllMethods(resourceClass, (m) -> true);
                    for (Method method : methodSet) {
                        GetMapping getMapping = method.getAnnotation(GetMapping.class);
                        if (getMapping != null) {
                            importClasses.add(GetMapping.class);
                            content.append("\t@GetMapping");
                            content.append("(\"" + classPath);
                            if (getMapping.value().length > 0) {
                                content.append(getMapping.value()[0]);
                            }
                            content.append("\")\n");
                        } else {
                            PostMapping postMapping = method.getAnnotation(PostMapping.class);
                            if (postMapping != null) {
                                importClasses.add(PostMapping.class);
                                content.append("\t@PostMapping");
                                content.append("(\"" + classPath);
                                if (postMapping.value().length > 0) {
                                    content.append(postMapping.value()[0]);
                                }
                                content.append("\")\n");
                            } else {
                                PutMapping putMapping = method.getAnnotation(PutMapping.class);
                                if (putMapping != null) {
                                    importClasses.add(PutMapping.class);
                                    content.append("\t@PutMapping");
                                    content.append("(\"" + classPath);
                                    if (putMapping.value().length > 0) {
                                        content.append(putMapping.value()[0]);
                                    }
                                    content.append("\")\n");
                                } else {
                                    DeleteMapping deleteMapping = method.getAnnotation(DeleteMapping.class);
                                    if (deleteMapping != null) {
                                        importClasses.add(DeleteMapping.class);
                                        content.append("\t@DeleteMapping");
                                        content.append("(\"" + classPath);
                                        if (deleteMapping.value().length > 0) {
                                            content.append(deleteMapping.value()[0]);
                                        }
                                        content.append("\")\n");
                                    } else {
                                        continue;
                                    }
                                }
                            }
                        }

                        content.append("\tResultVo");
                        // 获取返回值泛型
                        ApiOperation apiOperationAnnotation = method.getAnnotation(ApiOperation.class);
                        if (apiOperationAnnotation != null && apiOperationAnnotation.response() != Void.class) {
                            try {
                                String responseClass = apiOperationAnnotation.response().getSimpleName();
                                importClasses.add(apiOperationAnnotation.response());
                                String responseContainer = apiOperationAnnotation.responseContainer();
                                if (!StringUtils.isEmpty(responseContainer)) {
                                    responseContainer = responseContainer.replace(responseContainer.substring(0, 1), responseContainer.substring(0, 1).toUpperCase());
                                    content.append("<").append(responseContainer).append("<").append(responseClass).append(">>");
                                } else {
                                    content.append("<").append(responseClass).append(">");
                                }
                            } catch (Exception e) {
                                log.trace("返回值无泛型", e);
                            }
                        }
                        // 获取方法名
                        String methodName = classPath;
                        if (methodName.length() > 0) {
                            // 增加前缀，避免重名
                            methodName = methodName.replaceAll("/", "_");
                            if (methodName.startsWith("_")) {
                                methodName = methodName.substring(1);
                            }
                            if (!methodName.endsWith("_")) {
                                methodName += "_";
                            }
                        }
                        methodName += method.getName();
                        content.append(" ").append(methodName).append("(");
                        /* 获取参数，@Context注解属于jersey的上下文。生成feign的时候需要排除掉,DefaultValue也得去掉 */
                        Arrays.stream(method.getParameters()).forEach(param -> {
                            Arrays.stream(param.getAnnotations())
                                    /*.filter(p -> p.annotationType().getPackage().getName().startsWith("javax.ws.rs"))
                                    .filter(p -> !p.annotationType().equals(DefaultValue.class))*/.forEach(paramAnnotation -> {
                                content.append("@").append(paramAnnotation.annotationType().getSimpleName());
                                Class<?> paramAnnotationClass = paramAnnotation.annotationType();
                                importClasses.add(paramAnnotation.annotationType());
                                try {
                                    String v = paramAnnotationClass.getMethod("value").invoke(paramAnnotation).toString();
                                    content.append("(\"").append(v).append("\")");
                                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                                    log.debug("此注解不包含value属性{}", paramAnnotation.annotationType().getSimpleName(), e);
                                }
                                content.append(" ");
                            });
                            // 添加参数类型
                            content.append(param.getType().getSimpleName()).append(" ");
                            importClasses.add(param.getType());
                            // 添加参数名称
                            content.append(param.getName()).append(", ");
                        });
                        // 去除多余后缀连接符
                        if (method.getParameterCount() > 0) {
                            content.setLength(content.length() - ", ".length());
                        }
                        content.append(");\n\n");
                    }
                }
        );
        content.append("}");
        StringBuilder sb = new StringBuilder();
        importClasses.stream().filter(s -> !s.isPrimitive()).map(s -> String.format("import %s;\n", s.getName())).forEach(sb::append);
        sb.append("import java.util.*;\n");
        sb.append("import org.springframework.cloud.netflix.feign.FeignClient;\n");
        sb.append("\n/**\n*用户注解\n*/\n");
        return sb.toString() + content.toString();
    }

    /**
     * 获取所有的带Controller注解的类
     *
     * @return jersey 所有的resource
     */
    private Set<Class<?>> getControllerClass() {
        Set<Class<?>> set = Sets.newHashSet();
        Map<String, Object> beans = applicationContext.getBeansWithAnnotation(Controller.class);
        List<Object> classes = Lists.newArrayList();
        beans.values().stream()
                .filter(k -> !AopUtils.isJdkDynamicProxy(k))
                .filter(k -> getClassOfBean(k).getAnnotation(RequestMapping.class) != null)
                .forEach(classes::add);
        log.info("the register springmvc controller size is {}", classes.size());
        classes.forEach(v -> {
            Class<?> clazz = getClassOfBean(v);
            try {
                set.add(Thread.currentThread().getContextClassLoader().loadClass(clazz.getName()));
            } catch (Exception e) {
                set.add(clazz);
            }
            set.add(clazz);
        });
        /*将api和listing的Resource移除掉*/
//        set.remove(ApiListingResource.class);
        set.remove(ApiResourceController.class);
        set.remove(BasicErrorController.class);
        set.remove(ApiGenerateController.class);
        return set;
    }

    private Class<?> getClassOfBean(Object bean) {
        Class<?> clazz = bean.getClass();
        try {
            if (AopUtils.isAopProxy(bean)) {
                clazz = AopUtils.getTargetClass(bean);
            }
        } catch (Exception e) {
            log.error("getClassOfBean error", e);
        }
        return clazz;
    }
}
