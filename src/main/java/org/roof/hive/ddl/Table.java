package org.roof.hive.ddl;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.List;

/**
 * 表
 *
 * @author liuxin
 * @since 2018-12-23
 */
public class Table implements SqlUnit {

    private static final String TABLE_CREATE_SQL_TEMPLATE = "CREATE TABLE IF NOT EXISTS {0} ({1}) {2} {3}";

    private String dbName;
    private String tableName;
    private List<TableColumn> tableColumns;
    private TableComment tableComment;
    private TablePartitionedBy tablePartitionedBy;

    public Table(String tableName, List<TableColumn> tableColumns) {
        this.tableName = tableName;
        this.tableColumns = tableColumns;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<TableColumn> getTableColumns() {
        return tableColumns;
    }

    public void setTableColumns(List<TableColumn> tableColumns) {
        this.tableColumns = tableColumns;
    }

    public TableComment getTableComment() {
        return tableComment;
    }

    public void setTableComment(TableComment tableComment) {
        this.tableComment = tableComment;
    }

    public TablePartitionedBy getTablePartitionedBy() {
        return tablePartitionedBy;
    }

    public void setTablePartitionedBy(TablePartitionedBy tablePartitionedBy) {
        this.tablePartitionedBy = tablePartitionedBy;
    }

    @Override
    public String toSql() {
        String t = StringUtils.isBlank(dbName) ? tableName : dbName + "." + tableName;
        StringBuilder columns = new StringBuilder();
        int i = 1;
        for (TableColumn tableColumn : tableColumns) {
            columns.append(tableColumn.toSql());
            if (i < tableColumns.size()) {
                columns.append(",");
            }
            i++;
        }
        return MessageFormat.format(TABLE_CREATE_SQL_TEMPLATE, t, columns.toString(),
                tableComment == null ? "" : tableComment.toSql(),
                tablePartitionedBy == null ? "" : tablePartitionedBy.toSql());
    }
}
