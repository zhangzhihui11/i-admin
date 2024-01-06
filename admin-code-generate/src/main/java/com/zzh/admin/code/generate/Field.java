package com.zzh.admin.code.generate;

public class Field {

    private String javaType;

    private String name;

    public Field(String javaType, String name) {
        this.javaType = javaType;
        this.name = name;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
