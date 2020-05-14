package com.crm.apis.common.services.exceptions;

import com.crm.apis.common.services.web.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by Arpit Khandelwal.
 */
@ControllerAdvice
@RestController
@Slf4j
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.EntityNotFoundException.class)
    public final ResponseEntity handleNotFountExceptions(Exception ex, WebRequest request) {
        Response response = Response.notFound();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ServiceException.DuplicateEntityException.class)
    public final ResponseEntity handleNotFountExceptions1(Exception ex, WebRequest request) {
        Response response = Response.duplicateEntity();
        response.addErrorMsgToResponse(ex.getMessage(), ex);
        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(ServiceException.RequiredFieldException.class)
    public final ResponseEntity handleRequiredFieldExceptions(Exception ex, WebRequest request) {
        Response response = Response.validationException();
        response.addErrorMsgToResponse("RequiredField", ex);
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HibernateException.class)
    public final ResponseEntity handleDBExceptions(Exception ex, WebRequest request) {
        log.error(ex.getMessage());
        Response response = Response.dbException();
        response.addErrorMsgToResponse("DB", new Exception("DBException"));
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}