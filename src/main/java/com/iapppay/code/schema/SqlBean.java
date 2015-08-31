package com.iapppay.code.schema;

import java.util.List;

public class SqlBean {

    // 表名
    private String tableName;
    // 描述
    private String desc;
    // 列
    private List<MetaBean> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<MetaBean> getColumns() {
        return columns;
    }

    public void setColumns(List<MetaBean> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "SqlBean [tableName=" + tableName + ", desc=" + desc
                + ", columns=" + columns + "]";
    }

}
