package com.crm.apis.common.services.utils;

import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import java.util.Date;

public class ValidatorUtils {

    public static boolean isNotEmpty(Boolean value) {
        return !isEmpty(value);
    }
    public static boolean isEmpty(Boolean value) {
        return value == null;
    }


    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }
    public static boolean isEmpty(String value) {
        return value == null || value.length() ==0;
    }

    public static boolean isNotEmpty(Long value) {
        return value == null ;
    }
    public static boolean isEmpty(Long value) {
        return value == null ;
    }

    public static boolean isNotEmpty(Date value) {
        return !isEmpty(value);
    }
    public static boolean isEmpty(Date id) {
        return id == null ;
    }

    public static boolean emailIsValid(String email){
        EmailValidator a = new EmailValidator();
        return a.isValid(email, null);
    }
}
