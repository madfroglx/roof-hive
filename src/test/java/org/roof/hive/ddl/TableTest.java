package org.roof.hive.ddl;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liuxin
 * @since 2018-12-25
 */
public class TableTest {

    @Test
    public void toSql() {
        List<TableColumn> tableColumns = new ArrayList<>();
        tableColumns.add(new TableColumn("name", PrimitiveType.STRING.toString(), "姓名"));
        tableColumns.add(new TableColumn("addr", PrimitiveType.STRING.toString(), "地址"));
        tableColumns.add(new TableColumn("age", PrimitiveType.BIGINT.toString()));
        Table table = new Table("myTest", tableColumns);
        table.setDbName("a");
        table.setTableComment(new TableComment("ceshi"));
        List<TableColumn> partColumns = new ArrayList<>();
        partColumns.add(new TableColumn("dt", PrimitiveType.STRING.toString()));
        table.setTablePartitionedBy(new TablePartitionedBy(partColumns));
        System.out.println(table.toSql());
    }
}