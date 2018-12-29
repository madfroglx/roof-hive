package org.roof.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author liuxin
 * @since 2018-12-25
 */
@Service
public class VoidSqlExecutor extends AbstractSqlExecutor<Object> {

    @Override
    public Object doExecute(String sql) {
        jdbcTemplate.execute(sql);
        return Void.TYPE;
    }

    @Override
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }
}
