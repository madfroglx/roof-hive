package org.roof.hive;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author liuxin
 * @since 2018-12-25
 */
public abstract class AbstractSqlExecutor<T> implements SqlExecutor<T> {
    protected JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
