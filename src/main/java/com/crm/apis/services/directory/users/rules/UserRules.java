package com.crm.apis.services.directory.users.rules;

import com.crm.apis.common.services.exceptions.EntityType;
import com.crm.apis.common.services.exceptions.ExceptionType;
import com.crm.apis.common.services.exceptions.ServiceException;
import com.crm.apis.common.services.utils.ValidatorUtils;
import com.crm.apis.services.directory.users.domains.UserEmailEntity;
import com.crm.apis.services.directory.users.domains.UserEntity;
import com.crm.apis.services.directory.users.forms.User;
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
public class UserRules {

    private final UserRepository userRepository;

    public UserRules(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(UserEntity entity) {
        List<String> errors = new ArrayList<>(0);
        // check email
        if (ValidatorUtils.isEmpty(entity.getPrimaryEmail())) {
            errors.add("primaryEmail");
        } else if (!ValidatorUtils.emailIsValid(entity.getPrimaryEmail())) {
            errors.add("invalideEmail");
            throw ServiceException.throwException(EntityType.USER, ExceptionType.FIELD_INVALID_EXCEPTION, errors);
        } else {
            UserEntity email = userRepository.findByPrimaryEmail(entity.getPrimaryEmail());
            if (email != null) {
                errors.add("email.exit");
                throw ServiceException.throwException(EntityType.USER, ExceptionType.DUPLICATE_ENTITY, "email.exit");
            }
        }
        if (!errors.isEmpty()) {
            throw ServiceException.throwException(EntityType.USER, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        }

        // init primaryemail

        entity.getEmails().add(new UserEmailEntity(entity.getPrimaryEmail(), entity, true));
        return entity;
    }

    public UserEntity update(User form) {
        Optional<UserEntity> entity = null;
        List<String> errors = new ArrayList<>(0);
        if (form.getId() == null) {
            errors.add("id");
            throw ServiceException.throwException(EntityType.USER, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        }
        entity = userRepository.findById(form.getId());
        if (!entity.isPresent()) {
            errors.add("user.not.found");
            throw ServiceException.throwException(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, errors);
        }
        // check email
        if (ValidatorUtils.isEmpty(form.getPrimaryEmail())) {
            errors.add("primaryEmailv");
            throw ServiceException.throwException(EntityType.USER, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        } else if (!ValidatorUtils.emailIsValid(form.getPrimaryEmail())) {
            errors.add("invalideEmail");
            throw ServiceException.throwException(EntityType.USER, ExceptionType.FIELD_INVALID_EXCEPTION, errors);
        } else {
            UserEntity email = userRepository.findByPrimaryEmail(form.getPrimaryEmail());
            if (email != null && email.getId() != entity.get().getId()) {
                errors.add("email.exit");
                throw ServiceException.throwException(EntityType.USER, ExceptionType.DUPLICATE_ENTITY, errors);
            }
        }
        if (!errors.isEmpty()) {
            throw ServiceException.throwException(EntityType.USER, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        }


        return entity.get();
    }
}