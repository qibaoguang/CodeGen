package com.iapppay.code.schema;

import java.util.List;

public class XmlBean {

    // 命名空间
    private String nameSpace;
    // 全限定类名
    private String clazz;
    // 类名
    private String clazzName;
    // 表名
    private String tableName;
    // 列
    private List<MetaBean> columns;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<MetaBean> getColumns() {
        return columns;
    }

    public void setColumns(List<MetaBean> columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "XmlBean [nameSpace=" + nameSpace + ", clazz=" + clazz
                + ", clazzName=" + clazzName + ", tableName=" + tableName
                + ", columns=" + columns + "]";
    }

}
