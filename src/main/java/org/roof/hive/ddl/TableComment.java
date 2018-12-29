package org.roof.hive.ddl;

/**
 * 表注释
 *
 * @author liuxin
 * @since 2018-12-23
 */
public class TableComment implements SqlUnit {
    private String comment;

    public TableComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toSql() {
        return "COMMENT '" + comment + "'";
    }
}
