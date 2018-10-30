package com.jzg.svsp.common.mybatis.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author: wang.linqiao
 * @creation: 2018/10/22 9:56
 * @notes:
 */
public interface BaseMapper<T> {
    /**
     * 插入实体
     *
     * @param t
     * @return
     */
    @InsertProvider(type = BaseSqlProvider.class, method = "insert")
    int insert(T t);

    /**
     * 更新实体
     *
     * @param t
     * @return
     */
    @UpdateProvider(type = BaseSqlProvider.class, method = "update")
    int update(T t);


    /**
     * 根据ID删除实体
     *
     * @param t
     * @return
     */
    @DeleteProvider(type = BaseSqlProvider.class, method = "deleteById")
    int deleteById(T t);

    /**
     * 根据ID获取实体
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "getById")
    T getById(T t);


    /**
     * 模糊匹配查询实体
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "selectVague")
    List<T> selectVague(T t);

    /**
     * 模糊匹配查询实体  一条
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "selectOneVague")
    T selectOneVague(T t);

    /**
     * 准确查询实体
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "selectAccuracy")
    List<T> selectAccuracy(T t);

    /**
     * 精确查询一条
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "selectOneAccuracy")
    T selectOneAccuracy(T t);

    /**
     * 查询所有的实体
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "findAll")
    List<T> findAll(T t);

    /**
     * 统计总数
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "countAll")
    long countAll(T t);

    /**
     * 模糊匹配count
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "countVague")
    long countVague(T t);

    /**
     * 精确匹配count
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "countAccuracy")
    long countAccuracy(T t);

    /**
     * 删除所有的实体
     *
     * @param t
     * @return
     */
    @DeleteProvider(type = BaseSqlProvider.class, method = "deleteAll")
    long deleteAll(T t);

    /**
     * 模糊匹配删除
     *
     * @param t
     * @return
     */
    @DeleteProvider(type = BaseSqlProvider.class, method = "deleteVague")
    long deleteVague(T t);

    /**
     * 精确匹配删除
     *
     * @param t
     * @return
     */
    @DeleteProvider(type = BaseSqlProvider.class, method = "deleteAccuracy")
    long deleteAccuracy(T t);

    /**
     * 根据IDS查询
     *
     * @param t
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "selectByIds")
    List<T> selectByIds(T t);

    /**
     * 根据IDs删除
     *
     * @param t
     * @return
     */
    @DeleteProvider(type = BaseSqlProvider.class, method = "deleteByIds")
    int deleteByIds(T t);

    /**
     * 执行查询返回自定义的实体
     *
     * @param sql
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "sqlOne")
    T selectOne(String sql);

    /**
     * 执行查询返回自定义的实体
     *
     * @param sql
     * @param args
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "sqlArgsOne")
    T selectOneArgs(@Param("sql") String sql, @Param("args") Object... args);

    /**
     * sql查询实例列表
     *
     * @param sql
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "sql")
    List<T> select(String sql);

    /**
     * sql查询实例列表
     *
     * @param sql
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "sqlArgs")
    List<T> selectArgs(@Param("sql") String sql, @Param("args") Object... args);

    /**
     * sql查询 Map 列表
     *
     * @param sql
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "sql")
    List<Map<String, Object>> selectMap(String sql);

    /**
     * 带limit的精确查询
     *
     * @param t
     * @param limits
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "selectAccuracyLimit")
    List<T> selectAccuracyLimit(@Param("t") T t, @Param("limits") long... limits);

    /**
     * 带limit的模糊查询
     *
     * @param t
     * @param limits
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "selectVagueLimit")
    List<T> selectVagueLimit(@Param("t") T t, @Param("limits") long... limits);

    /**
     * @param sql   select * from a where id = #{param.id}
     * @param param
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "sqlParam")
    List<T> selectParam(@Param("sql") String sql, @Param("param") Object param);


    /**
     * @param sql   select * from a where id = #{param.id} limit 1
     * @param param
     * @return
     */
    @SelectProvider(type = BaseSqlProvider.class, method = "sqlParamOne")
    T selectOneParam(@Param("sql") String sql, @Param("param") Object param);
}
