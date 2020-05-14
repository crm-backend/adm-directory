package com.crm.apis.common.services.init;

import com.crm.apis.common.services.exceptions.EntityType;
import com.crm.apis.common.services.exceptions.ExceptionType;
import com.crm.apis.common.services.exceptions.ServiceException;

public class CommonService {

    /**
     * Returns a new RuntimeException
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    protected RuntimeException exception(EntityType entityType, ExceptionType exceptionType, String... args) {
        return ServiceException.throwException(entityType, exceptionType, args);
    }

    /**
     * Returns a new RuntimeException
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    protected RuntimeException exceptionWithId(EntityType entityType, ExceptionType exceptionType, String id, String... args) {
        return ServiceException.throwExceptionWithId(entityType, exceptionType, id, args);
    }
}
