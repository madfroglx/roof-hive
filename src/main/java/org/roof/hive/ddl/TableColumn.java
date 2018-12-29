package org.roof.hive.ddl;

import org.apache.commons.lang3.StringUtils;

/**
 * 表的列
 *
 * @author liuxin
 * @since 2018-12-23
 */
public class TableColumn implements SqlUnit {
    private String colName;
    private String dataType;
    private String colComment;

    public TableColumn(String colName, String dataType) {
        this.colName = colName;
        this.dataType = dataType;
    }

    public TableColumn(String colName, String dataType, String colComment) {
        this.colName = colName;
        this.dataType = dataType;
        this.colComment = colComment;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getColComment() {
        return colComment;
    }

    public void setColComment(String colComment) {
        this.colComment = colComment;
    }

    @Override
    public String toSql() {
        String result = colName + " " + dataType;
        if (StringUtils.isNotBlank(colComment)) {
            result += " COMMENT '" + colComment + "'";
        }
        return result;
    }
}
