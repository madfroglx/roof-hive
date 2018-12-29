package org.roof.hive.controller;

import org.roof.hive.SqlExecutor;
import org.roof.hive.ddl.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxin
 * @since 2018-12-25
 */
@RestController
@RequestMapping("/hive")
public class HiveController {
    private SqlExecutor lineSqlExecutor;


    @RequestMapping("/createTable")
    public Object createTable(Table table) {
        return lineSqlExecutor.doExecute(table.toSql());
    }

    @RequestMapping("/query")
    public Object query(String sql) {
        return lineSqlExecutor.doExecute(sql);
    }

    @RequestMapping("/query2File")
    public Object query2File() {
        return null;
    }

    @Autowired
    public void setLineSqlExecutor(@Qualifier("lineSqlExecutor") SqlExecutor lineSqlExecutor) {
        this.lineSqlExecutor = lineSqlExecutor;
    }
}
