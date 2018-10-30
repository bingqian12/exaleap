package com.jzg.svsp.common.mybatis.context;

import com.google.common.collect.Lists;
import com.jzg.svsp.common.mybatis.annotations.MyColumn;
import com.jzg.svsp.common.mybatis.annotations.MyMany;
import com.jzg.svsp.common.mybatis.exception.One2ManyException;
import com.jzg.svsp.common.mybatis.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.reflections.ReflectionUtils;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 一对多关系的上下文
 *
 * @author: wang.linqiao
 * @creation: 2018/10/26 19:21
 * @notes:
 */
@Slf4j
public class ManyContext extends AbstractContext {
    private ManyContext() {
    }

    /**
     * 构建一对多关系上下文
     *
     * @param clazz
     * @return
     */
    public static List<ManyContext> buildContext(Class<?> clazz) {
        List<ManyContext> contextList = Lists.newArrayList();
        /*循环构建所有的一对多的上下文*/
        for (Field field : ReflectionUtils.getAllFields(clazz, ReflectionUtils.withAnnotation(MyMany.class))) {
            /*一对多的关系必须是数组或者Collection的子类*/
            if (Collection.class.isAssignableFrom(field.getType()) || field.getType().isArray()) {
                MyMany many = field.getAnnotation(MyMany.class);
                /*获取一对多的另一个实体的类型。如果是list从泛型获取，数组从getComponentType获取*/
                Class<?> manyClass = getOtherClass(field);
                String ownFieldName = many.ownField();
                String otherFieldName = many.otherField();
                /*获取一对多自己的关联的字段*/
                Field ownField = getOwnField(clazz, ownFieldName);
                if (ownField != null) {
                    /*获取一对多另一个实体的关联字段*/
                    Set<Field> otherFieldSet = ReflectionUtils.getAllFields(manyClass,
                            ReflectionUtils.withName(otherFieldName), ReflectionUtils.withAnnotation(MyColumn.class));
                    Field otherField = otherFieldSet.isEmpty() ? null : otherFieldSet.iterator().next();
                    if (otherField != null) {
                        /*组装一对多的上下文*/
                        ManyContext manyContext = new ManyContext();
                        manyContext.setOwnClazz(clazz);
                        manyContext.setOwnField(ownField);
                        manyContext.setOtherField(otherField);
                        manyContext.setOtherClass(manyClass);
                        manyContext.setRelationField(field);
                        contextList.add(manyContext);
                    } else {
                        /*其他实体的的字段找不到*/
                        log.error("[{}] @MyMany reference other field [{}] error,it with not @MyColumn",
                                clazz.getName(), otherFieldName);
                        throw new One2ManyException(String.format(
                                "[%s] @MyMany reference other field [%s] error,it with not @MyColumn", clazz.getName(), otherFieldName));
                    }
                } else {
                    /*映射的自己的字段找不到*/
                    log.error("[{}] @MyMany reference own field [{}] error,it with not @MyColumn or @MyId ", clazz.getName(), ownFieldName);
                    throw new One2ManyException(String.format(
                            "[%s] @MyMany reference own field [%s] error,it with not @MyColumn or @MyId", clazz.getName(), ownFieldName));
                }
            } else {
                /*一对多的关系的实体的字段类别不是数组或者集合*/
                log.error("[{}] @MyMany field [{}] type error [{}],it will be collection or Array", clazz.getName(), field.getName(), field.getType());
                throw new One2ManyException(String.format(
                        "[%s] @MyMany field [%s] type error [%s],it will be collection or Array", clazz.getName(), field.getName(), field.getType()));
            }
        }
        return contextList;
    }

    @Override
    public void assembly(Object t) {
        try {
            Field ownField = getOwnField();
            Field otherField = getOtherField();
            Object ownFieldValue = ownField.get(t);
            Class<?> manyClass = getOtherClass();
            Field field = getRelationField();
            if (ownFieldValue != null && StringUtils.isNotEmpty(String.valueOf(ownFieldValue))) {
                Object reference = manyClass.newInstance();
                otherField.set(reference, ownFieldValue);
                /*执行查询赋值*/
                BaseService baseService = MybatisContext.getBaseServiceByEntityClass(manyClass);
                if (baseService != null) {
                    List list = baseService.selectAccuracy(reference);
                    if (!CollectionUtils.isEmpty(list)) {
                        if (field.getType().isArray()) {
                            Object array = Array.newInstance(manyClass, list.size());
                            for (int i = 0; i < list.size(); i++) {
                                Array.set(array, i, list.get(i));
                            }
                            field.set(t, array);
                        } else if (field.getType().equals(Collection.class) || field.getType().equals(List.class)) {
                            field.set(t, list);
                        } else if (field.getType().equals(Set.class)) {
                            field.set(t, new HashSet<>(list));
                        } else if (!field.getType().isInterface()) {
                            Collection collection = Collection.class.cast(field.getType().newInstance());
                            collection.addAll(list);
                            field.set(t, collection);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
