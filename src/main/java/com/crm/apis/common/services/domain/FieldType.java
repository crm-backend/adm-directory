package com.crm.apis.common.services.domain;

public  enum FieldType {

    BOOLEAN("boolean"),
    STRING("string"),
    DATE("date"),
    DATETIME("datetime"),
    DOUBLE("double");


    private String type;

    FieldType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
