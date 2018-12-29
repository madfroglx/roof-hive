package org.roof.hive;

/**
 * SQL 执行器
 *
 * @author liuxin
 * @since 2018-12-25
 */
public interface SqlExecutor<T> {
    T doExecute(String sql);
}
