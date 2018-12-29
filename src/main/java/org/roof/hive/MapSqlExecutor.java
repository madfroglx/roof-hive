package org.roof.hive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author liuxin
 * @since 2018-12-25
 */
@Service
public class MapSqlExecutor extends AbstractSqlExecutor<List<Map<String, Object>>> {

    @Override
    public List<Map<String, Object>> doExecute(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

    @Autowired
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }
}
