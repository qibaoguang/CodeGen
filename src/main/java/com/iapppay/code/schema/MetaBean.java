package com.iapppay.code.schema;

public class MetaBean {
    // 原始名称
    private String primitiveName;
    // 原始类型
    private Class<?> primitiveType;
    // 输出名称
    private String outName;
    // 输出类型
    private String outType;
    // 描述
    private String comment;

    public String getPrimitiveName() {
        return primitiveName;
    }

    public void setPrimitiveName(String primitiveName) {
        this.primitiveName = primitiveName;
    }

    public String getOutName() {
        return outName;
    }

    public void setOutName(String outName) {
        this.outName = outName;
    }

    public String getOutType() {
        return outType;
    }

    public void setOutType(String outType) {
        this.outType = outType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Class<?> getPrimitiveType() {
        return primitiveType;
    }

    public void setPrimitiveType(Class<?> primitiveType) {
        this.primitiveType = primitiveType;
    }

    @Override
    public String toString() {
        return "MetaBean [primitiveName=" + primitiveName + ", primitiveType="
                + primitiveType + ", outName=" + outName + ", outType="
                + outType + ", comment=" + comment + "]";
    }

}
