package com.crm.apis.common.services.exceptions;
import com.crm.apis.common.services.init.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A helper class to generate RuntimeExceptions with a little AI inbuilt.
 * <p>
 * Created by Arpit Khandelwal.
 */
@Component
public class ServiceException {

    private static PropertiesConfig propertiesConfig;

    @Autowired
    public ServiceException(PropertiesConfig propertiesConfig) {
        ServiceException.propertiesConfig = propertiesConfig;
    }

    /**
     * Returns new RuntimeException based on template and args
     *
     * @param messageTemplate
     * @param args
     * @return
     */
    public static RuntimeException throwException(String messageTemplate, String... args) {
        return new RuntimeException(format(messageTemplate, args));
    }

    /**
     * Returns new RuntimeException based on EntityType, ExceptionType and args
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    public static RuntimeException throwException(EntityType entityType, ExceptionType exceptionType, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType);
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * Returns new RuntimeException based on EntityType, ExceptionType and args
     *
     * @param entityType
     * @param exceptionType
     * @param args
     * @return
     */
    public static RuntimeException throwExceptionWithId(EntityType entityType, ExceptionType exceptionType, String id, String... args) {
        String messageTemplate = getMessageTemplate(entityType, exceptionType).concat(".").concat(id);
        return throwException(exceptionType, messageTemplate, args);
    }

    /**
     * Returns new RuntimeException based on EntityType, ExceptionType, messageTemplate and args
     *
     * @param entityType
     * @param exceptionType
     * @param messageTemplate
     * @param args
     * @return
     */
    public static RuntimeException throwExceptionWithTemplate(EntityType entityType, ExceptionType exceptionType, String messageTemplate, String... args) {
        return throwException(exceptionType, messageTemplate, args);
    }

    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException(String message) {
            super(message);
        }
    }

    public static class RequiredFieldException extends RuntimeException {
        public RequiredFieldException(String message) {
            super(message);
        }
    }
    public static class DBException extends RuntimeException {
        public DBException(String message) {
            super(message);
        }
    }
    /**
     * Returns new RuntimeException based on template and args
     *
     * @param messageTemplate
     * @param args
     * @return
     */
    private static RuntimeException throwException(ExceptionType exceptionType, String messageTemplate, String... args) {
        if (ExceptionType.ENTITY_NOT_FOUND.equals(exceptionType)) {
            return new EntityNotFoundException(format(messageTemplate, args));
        } else if (ExceptionType.DUPLICATE_ENTITY.equals(exceptionType)) {
            return new DuplicateEntityException(format(messageTemplate, args));
        }
        return new RuntimeException(format(messageTemplate, args));
    }
    public static RuntimeException throwException(EntityType user, ExceptionType messageTemplate, List<String> errors) {
        return new RequiredFieldException(format(messageTemplate, errors));
    }

    private static String format(ExceptionType messageTemplate, List<String> errors) {
        List<String> messages = new ArrayList<>(0);
        errors.forEach(a -> {
            messages.add(format(messageTemplate.getValue(),a));
        });
        return String.join(";",messages);
    }

    private static String getMessageTemplate(EntityType entityType, ExceptionType exceptionType) {
        return entityType.name().concat(".").concat(exceptionType.getValue()).toLowerCase();
    }

    private static String format(String template, String... args) {
        Optional<String> templateContent = Optional.ofNullable(propertiesConfig.getConfigValue(template));
        if (templateContent.isPresent()) {
            return MessageFormat.format(templateContent.get(), args);
        }
        return String.format(template, args);
    }

}