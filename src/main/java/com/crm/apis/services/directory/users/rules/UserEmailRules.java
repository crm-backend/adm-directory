package com.crm.apis.services.directory.users.rules;

import com.crm.apis.common.services.exceptions.EntityType;
import com.crm.apis.common.services.exceptions.ExceptionType;
import com.crm.apis.common.services.exceptions.ServiceException;
import com.crm.apis.common.services.utils.ValidatorUtils;
import com.crm.apis.services.directory.users.domains.UserEmailEntity;
import com.crm.apis.services.directory.users.domains.UserEntity;
import com.crm.apis.services.directory.users.repositories.UserEmailRepository;
import com.crm.apis.services.directory.users.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * UserRoles.
 *
 * @author PoleData.
 */
@Component
@Slf4j
public class UserEmailRules {

    private final UserEmailRepository userEmailRepository;

    public UserEmailRules(UserEmailRepository userEmailRepository) {
        this.userEmailRepository = userEmailRepository;
    }

    public UserEmailEntity create(UserEmailEntity entity) {
        List<String> errors = new ArrayList<>(0);
        if (ValidatorUtils.isEmpty(entity.getUserId())) {
            errors.add("userId");
            throw ServiceException.throwException(EntityType.USER_EMAIL, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        }
        // check email
        if (ValidatorUtils.isEmpty(entity.getEmail())) {
            errors.add("email");
            throw ServiceException.throwException(EntityType.USER_EMAIL, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        } else if (!ValidatorUtils.emailIsValid(entity.getEmail())) {
            errors.add("invalideEmail");
            throw ServiceException.throwException(EntityType.USER_EMAIL, ExceptionType.FIELD_INVALID_EXCEPTION, errors);
        }
        long count = userEmailRepository.countUserIdAndEmail(entity.getUserId(), entity.getEmail());
        if(count>0) {
            errors.add("email.exist");
            throw ServiceException.throwException(EntityType.USER_EMAIL, ExceptionType.DUPLICATE_ENTITY, errors);
        }
        return entity;
    }


}