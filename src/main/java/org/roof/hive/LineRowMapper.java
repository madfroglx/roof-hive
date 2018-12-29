package org.roof.hive;


import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @author liuxin
 * @since 2018-12-25
 */
public class LineRowMapper implements RowMapper<String> {
    private static String colSpliter = " ";

    public LineRowMapper() {
    }

    public LineRowMapper(String colSpliter) {
        this.colSpliter = colSpliter;
    }

    @Override
    public String mapRow(ResultSet resultSet, int i) throws SQLException {
        StringBuilder row = new StringBuilder();
        for (int j = 1; j <= resultSet.getMetaData().getColumnCount(); j++) {
            Object val = JdbcUtils.getResultSetValue(resultSet, j);
            row.append(Objects.toString(val, StringUtils.EMPTY));
            if (j < resultSet.getMetaData().getColumnCount()) {
                row.append(colSpliter);
            }
        }
        return row.toString();
    }
}
