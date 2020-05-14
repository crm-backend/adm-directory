package com.crm.apis.common.services.exceptions;
/**
 * Created by sass.hicham@gmail.Com.
 */
public enum ExceptionType {
    ENTITY_NOT_FOUND("not.found"),
    DUPLICATE_ENTITY("duplicate"),
    ENTITY_EXCEPTION("exception"),
    DB_EXCEPTION("db.exception"),
    FIELD_REQUIRED_EXCEPTION("field.required.exception"),
    FIELD_INVALID_EXCEPTION("field.invalid.exception");

    String value;

    ExceptionType(String value) {
        this.value = value;
    }

    String getValue() {
        return this.value;
    }
}