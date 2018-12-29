package org.roof.hive.ddl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author liuxin
 * @since 2018-12-23
 */
public class TablePartitionedBy implements SqlUnit {
    private List<TableColumn> tableColumns;

    public TablePartitionedBy(List<TableColumn> tableColumns) {
        this.tableColumns = tableColumns;
    }

    public List<TableColumn> getTableColumns() {
        return tableColumns;
    }

    public void setTableColumns(List<TableColumn> tableColumns) {
        this.tableColumns = tableColumns;
    }

    @Override
    public String toSql() {
        if (CollectionUtils.isEmpty(tableColumns)) {
            return StringUtils.EMPTY;
        }
        StringBuilder result = new StringBuilder("PARTITIONED BY (");
        int i = 0;
        for (TableColumn tableColumn : tableColumns) {
            result.append(tableColumn.toSql());
            if (i < tableColumns.size() - 1) {
                result.append(",");
            }
            i++;
        }
        result.append(")");
        return result.toString();
    }
}
