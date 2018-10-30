package com.jzg.svsp.common.mybatis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.jzg.svsp.common.mybatis.context.ManyContext;
import com.jzg.svsp.common.mybatis.context.OneContext;
import com.jzg.svsp.common.mybatis.exception.MapperUnsuitedException;
import com.jzg.svsp.common.mybatis.mapper.BaseMapper;
import com.jzg.svsp.common.mybatis.mapper.BaseSqlProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperProxy;
import org.reflections.ReflectionUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/22 11:07
 * @notes:
 */
@Slf4j
public class BaseService<M extends BaseMapper<T>, T> implements InitializingBean {
    /**
     * 实体mapper
     */
    @Autowired
    protected M mapper;
    /**
     * 具体操作的实体类
     */
    private Class<T> clazz;

    /**
     * 一对多映射关系
     */
    private List<ManyContext> manyContexts;

    /**
     * 一对多映射关系
     */
    private List<OneContext> oneContexts;

    /**
     * 添加实体
     *
     * @param t
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean add(T t) {
        log.debug("add {},value is {}", clazz.getSimpleName(), t);
        return mapper.insert(t) > 0;
    }

    /**
     * 批量添加的接口
     *
     * @param list
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int batchAdd(Collection<T> list) {
        log.debug("batchAdd {},size is {}", clazz.getSimpleName(), list.size());
        int count = 0;
        for (T t : list) {
            count = count + mapper.insert(t);
        }
        return count;
    }

    /**
     * 更新实体
     *
     * @param t
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean update(T t) {
        log.debug("update {},value is {}", clazz.getSimpleName(), t);
        return mapper.update(t) > 0;
    }

    /**
     * 保存或者修改实体
     *
     * @param t
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(T t) throws Exception {
        log.debug("saveOrUpdate {},value is {}", clazz.getSimpleName(), t);
        Field field = BaseSqlProvider.getIdField(t);
        Object id = field.get(t);
        boolean updateFlag = id != null && getById(id) != null;
        return updateFlag ? update(t) : add(t);
    }

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Object id) {
        log.debug("deleteById {},id value is {}", clazz.getSimpleName(), id);
        T t = assembly(id);
        return mapper.deleteById(t) > 0;
    }

    /**
     * 根据ID删除
     *
     * @param t
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteEntity(T t) {
        log.debug("deleteEntity {},value is {}", clazz.getSimpleName(), t);
        return mapper.deleteById(t) > 0;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    public T getById(Object id) {
        log.debug("getById {},id value is {}", clazz.getSimpleName(), id);
        T t = assembly(id);
        t = mapper.getById(t);
        assemblyMany(t);
        assemblyOne(t);
        return t;
    }


    /**
     * 根据IDS查询，用逗号隔开
     *
     * @param ids
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> getByIds(Object ids) {
        log.debug("getByIds {},ids value is {}", clazz.getSimpleName(), ids);
        T t = assembly(ids);
        return mapper.selectByIds(t);
    }

    /**
     * 根据Id的集合查询
     *
     * @param ids
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> getByIds(Collection<?> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return Lists.newArrayList();
        }
        Set<String> set = Sets.newHashSet();
        ids.stream().map(String::valueOf).forEach(set::add);
        T t = assembly(String.join(",", set));
        return mapper.selectByIds(t);
    }

    /**
     * 根据IDs删除，用逗号隔开
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteByIds(Object ids) {
        log.debug("deleteByIds {},ids value is {}", clazz.getSimpleName(), ids);
        T t = assembly(ids);
        return mapper.deleteByIds(t);
    }

    /**
     * 根据Id的集合删除
     *
     * @param ids
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public int deleteByIds(Collection<?> ids) {
        log.debug("deleteByIds {},ids value is {}", clazz.getSimpleName(), ids);
        if (CollectionUtils.isEmpty(ids)) {
            return 0;
        }
        Set<String> set = Sets.newHashSet();
        ids.stream().map(String::valueOf).forEach(set::add);
        T t = assembly(String.join(",", set));
        return mapper.deleteByIds(t);
    }


    /**
     * 根据ID查询
     *
     * @param t
     * @return
     */
    @Transactional(readOnly = true)
    public T getEntity(T t) {
        log.debug("getEntity {},value is {}", clazz.getSimpleName(), t);
        t = mapper.getById(t);
        assemblyOne(t);
        assemblyMany(t);
        return t;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> findAll() {
        log.debug("findAll {}", clazz.getSimpleName());
        T t = assembly();
        return mapper.findAll(t);
    }

    /**
     * 模糊匹配查询
     *
     * @param t
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> selectVague(T t) {
        log.debug("selectVagueParamAlias {},value is {}", clazz.getSimpleName(), t);
        return mapper.selectVague(t);
    }

    /**
     * 执行limit查询
     *
     * @param t
     * @param limits
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> selectVagueLimit(T t, long... limits) {
        return mapper.selectVagueLimit(t, limits);
    }

    /**
     * 模糊匹配查询一条
     *
     * @param t
     * @return
     */
    @Transactional(readOnly = true)
    public T selectOneVague(T t) {
        log.debug("selectOneVague {},value is {}", clazz.getSimpleName(), t);
        t = mapper.selectOneVague(t);
        assemblyMany(t);
        assemblyOne(t);
        return t;
    }

    /**
     * 查询总数
     *
     * @return
     */
    @Transactional(readOnly = true)
    public long countAll() {
        log.debug("countAll {}", clazz.getSimpleName());
        T t = assembly();
        return mapper.countAll(t);
    }

    /**
     * 精确匹配查询
     *
     * @param t
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> selectAccuracy(T t) {
        log.debug("selectAccuracy {},value is {}", clazz.getSimpleName(), t);
        return mapper.selectAccuracy(t);
    }

    /**
     * 精确匹配查询一条
     *
     * @param t
     * @return
     */
    public T selectOneAccuracy(T t) {
        log.debug("selectOneAccuracy {},value is {}", clazz.getSimpleName(), t);
        t = mapper.selectOneAccuracy(t);
        assemblyMany(t);
        assemblyOne(t);
        return t;
    }

    /**
     * 执行limit查询
     *
     * @param t
     * @param limits
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> selectAccuracyLimit(T t, long... limits) {
        return mapper.selectAccuracyLimit(t, limits);
    }

    /**
     * 模糊匹配,查询总数
     *
     * @param t
     * @return
     */
    @Transactional(readOnly = true)
    public long countVague(T t) {
        log.debug("countVague {},value is {}", clazz.getSimpleName(), t);
        return mapper.countVague(t);
    }

    /**
     * 精确匹配,查询总数
     *
     * @param t
     * @return
     */
    @Transactional(readOnly = true)
    public long countAccuracy(T t) {
        log.debug("countAccuracy {},value is {}", clazz.getSimpleName(), t);
        return mapper.countAccuracy(t);
    }

    /**
     * 删除所有的实体
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public long deleteAll() {
        log.debug("deleteAll {} ", clazz.getSimpleName());
        T t = assembly();
        return mapper.deleteAll(t);
    }

    /**
     * 模糊匹配删除实体
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public long deleteVague(T t) {
        log.debug("deleteVague {},value is {}", clazz.getSimpleName(), t);
        return mapper.deleteVague(t);
    }

    /**
     * 精确匹配删除实体
     *
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public long deleteAccuracy(T t) {
        log.debug("deleteAccuracy {},value is {}", clazz.getSimpleName(), t);
        return mapper.deleteAccuracy(t);
    }

    /**
     * 模糊匹配分页查询
     *
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public PageInfo<T> pageVague(T t, int pageNum, int pageSize) {
        log.debug("pageVague {},value is {},pageNum is {},pagetSize is {}", clazz.getSimpleName(), t, pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = mapper.selectVague(t);
        return new PageInfo<>(list);
    }

    /**
     * 自定义SQL的分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param sql
     * @param args
     * @param
     * @return
     */
    @Transactional(readOnly = true)
    public PageInfo<T> pageSQL(int pageNum, int pageSize, String sql, Object... args) {
        log.debug("pageVague {},pageNum is {},pagetSize is {}，SQL is {} ,args is {}", clazz.getSimpleName(), pageNum, pageSize, sql, args);
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = args.length == 0 ? mapper.select(sql) : mapper.selectArgs(sql, args);
        return new PageInfo<>(list);
    }

    /**
     * 精确匹配分页查询
     *
     * @param t
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Transactional(readOnly = true)
    public PageInfo<T> pageAccuracy(T t, int pageNum, int pageSize) {
        log.debug("pageAccuracy {},value is {},pageNum is {},pagetSize is {}", clazz.getSimpleName(), t, pageNum, pageSize);
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = mapper.selectAccuracy(t);
        return new PageInfo<>(list);
    }

    /**
     * sql带参数查询单条
     *
     * @param sql
     * @return
     */
    @Transactional(readOnly = true)
    public T selectOne(String sql, Object... args) {
        T t = args.length == 0 ? mapper.selectOne(sql) : mapper.selectOneArgs(sql, args);
        assemblyOne(t);
        assemblyMany(t);
        return t;
    }

    /**
     * sql查询列表
     *
     * @param sql
     * @param args
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> select(String sql, Object... args) {
        return args.length == 0 ? mapper.select(sql) : mapper.selectArgs(sql, args);
    }

    /**
     * select * from a where id = #{param.id}
     *
     * @param sql
     * @param obj
     * @return
     */
    @Transactional(readOnly = true)
    public List<T> selectParam(String sql, Object obj) {
        return mapper.selectParam(sql, obj);
    }

    /**
     * select * from a where id = #{param.id} limti 1
     *
     * @param sql
     * @param obj
     * @return
     */
    @Transactional(readOnly = true)
    public T selectOneParam(String sql, Object obj) {
        return mapper.selectOneParam(sql, obj);
    }


    /**
     * 通过ID，反射创建实体
     *
     * @param id
     * @return
     */
    private T assembly(Object id) {
        try {
            T t = clazz.newInstance();
            Field field = BaseSqlProvider.getIdField(t);
            field.set(t, id);
            return t;
        } catch (Exception e) {
            log.error("assembly entity with id error", e);
            return null;
        }
    }

    /**
     * 反射创建实体
     *
     * @return
     */
    private T assembly() {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            log.error("assembly entity without id error", e);
            return null;
        }
    }

    /**
     * 获取实体的class
     *
     * @return
     */
    public Class<T> getEntityClass() {
        return clazz;
    }

    protected void assemblyMany(T t) {
        if (t != null) {
            manyContexts.forEach(context -> context.assembly(t));
        }
    }

    protected void assemblyOne(T t) {
        if (t != null) {
            oneContexts.forEach(context -> context.assembly(t));
        }
    }


    /*
     * 获取泛型的class
     * 获取一对一，一对多的关系
     * @see
     * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @SuppressWarnings("all")
    @Override
    public void afterPropertiesSet() throws Exception {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType pt = ParameterizedType.class.cast(type);
        clazz = Class.class.cast(pt.getActualTypeArguments()[1]);
        Class<?> interfaces = Class.class.cast(pt.getActualTypeArguments()[0]);
        /*检测mapper是否合规*/
        if (mapper != null && !interfaces.isAssignableFrom(mapper.getClass())) {
            String msg = "[%s] required mapper is [%s],but spring autowired is [%s]";
            MapperProxy<?> mapperProxy = MapperProxy.class.cast(Proxy.getInvocationHandler(mapper));
            Field field = ReflectionUtils.getAllFields(mapperProxy.getClass(), ReflectionUtils.withName("mapperInterface")).iterator().next();
            field.setAccessible(true);
            String proxyMapper = Class.class.cast(field.get(mapperProxy)).getName();
            msg = String.format(msg, getClass().getName(), interfaces.getName(), proxyMapper);
            throw new MapperUnsuitedException(msg);
        }
        log.info("the {} service's entity is {},mapper is {}", getClass().getName(), clazz.getName(), interfaces.getName());
        /*创建一对多关系上下文*/
        manyContexts = ManyContext.buildContext(clazz);
        if (manyContexts.size() > 0) {
            log.info("assembly the one2many relation success");
            manyContexts.forEach(context ->
                    log.info("\none2many field is {},one refrece field is {},many refrence filed is {} ,many class is {}",
                            context.getRelationField().getName(), context.getOwnField().getName(), context.getOtherField().getName(), context.getOtherClass().getName())
            );
        }
        /*创建一对一关系上下文*/
        oneContexts = OneContext.buildContext(clazz);
        if (oneContexts.size() > 0) {
            log.info("assembly the one2one relation success");
            oneContexts.forEach(context ->
                    log.info("\none2one field is {},one refrece field is {},many refrence filed is {} ,many class is {}",
                            context.getRelationField().getName(), context.getOwnField().getName(), context.getOtherField().getName(), context.getOtherClass().getName())
            );
        }
    }

}
