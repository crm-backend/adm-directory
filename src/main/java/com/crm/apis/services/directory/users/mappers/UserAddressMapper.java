package com.crm.apis.services.directory.users.mappers;

import com.crm.apis.services.directory.users.domains.UserAddressEntity;
import com.crm.apis.services.directory.users.domains.UserEmailEntity;
import com.crm.apis.services.directory.users.forms.UserAddress;
import com.crm.apis.services.directory.users.forms.UserEmail;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * UserMapper.
 *
 * @author PoleData.
 */
@Component
@Slf4j
public class UserAddressMapper {

    private ModelMapper modelMapper;

    public UserAddressMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserAddressEntity toDomain(UserAddress form) {
        return modelMapper.map(form, UserAddressEntity.class);
    }

    public UserAddress toForm(UserAddressEntity entity) {
        return modelMapper.map(entity, UserAddress.class);
    }
}