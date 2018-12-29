package org.roof.hive;

import java.util.List;

/**
 * @author liuxin
 * @since 2018-12-28
 */
public class SqlLineResult {
    private String[] columns;
    private String[] rows;

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public String[] getRows() {
        return rows;
    }

    public void setRows(String[] rows) {
        this.rows = rows;
    }
}
