package com.crm.apis.services.directory.users.rules;

import com.crm.apis.common.services.exceptions.EntityType;
import com.crm.apis.common.services.exceptions.ExceptionType;
import com.crm.apis.common.services.exceptions.ServiceException;
import com.crm.apis.common.services.utils.ValidatorUtils;
import com.crm.apis.services.directory.users.domains.UserAddressEntity;
import com.crm.apis.services.directory.users.repositories.UserAddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * UserRoles.
 *
 * @author PoleData.
 */
@Component
@Slf4j
public class UserAddressRules {

    private final UserAddressRepository userAddressRepository;

    public UserAddressRules(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    public UserAddressEntity create(UserAddressEntity entity) {
        List<String> errors = new ArrayList<>(0);
        if (ValidatorUtils.isEmpty(entity.getUserId())) {
            errors.add("userId");
            throw ServiceException.throwException(EntityType.USER_EMAIL, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        }
        // check streetAddress
        if (ValidatorUtils.isEmpty(entity.getStreetAddress())) {
            errors.add("streetAddress");
            throw ServiceException.throwException(EntityType.USER_EMAIL, ExceptionType.FIELD_REQUIRED_EXCEPTION, errors);
        }

        return entity;
    }


}