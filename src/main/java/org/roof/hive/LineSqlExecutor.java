package org.roof.hive;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author liuxin
 * @since 2018-12-25
 */
@Service
public class LineSqlExecutor extends AbstractSqlExecutor<SqlLineResult> {

    @Override
    public SqlLineResult doExecute(String sql) {
        return jdbcTemplate.query(sql, resultSet -> {
            SqlLineResult result = new SqlLineResult();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int size = resultSet.getRow();
            int columnCount = metaData.getColumnCount();
            String[] columns = createColumns(metaData);
            List<String> rows = createRows(resultSet, size, columnCount);
            result.setColumns(columns);
            result.setRows(rows.toArray(ArrayUtils.EMPTY_STRING_ARRAY));
            return result;
        });
    }

    private List<String> createRows(ResultSet resultSet, int size, int columnCount) throws SQLException {
        List<String> rows = new ArrayList<>(size);
        while (resultSet.next()) {
            StringBuilder row = new StringBuilder();
            for (int i = 1; i <= columnCount; i++) {
                Object val = JdbcUtils.getResultSetValue(resultSet, i);
                row.append(Objects.toString(val, StringUtils.EMPTY));
                if (i < columnCount) {
                    row.append(" ");
                }
            }
            rows.add(row.toString());
        }
        return rows;
    }

    private String[] createColumns(ResultSetMetaData metaData) throws SQLException {
        int columnCount = metaData.getColumnCount();
        String[] columns = new String[columnCount];
        for (int i = 1; i <= columnCount; i++) {
            columns[i - 1] = metaData.getColumnName(i);
        }
        return columns;
    }

    @Autowired
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        super.setJdbcTemplate(jdbcTemplate);
    }
}
