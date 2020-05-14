package com.crm.apis.services.directory.users.mappers;

import com.crm.apis.services.directory.users.domains.UserEmailEntity;
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
public class UserEmailMapper {

    private ModelMapper modelMapper;

    public UserEmailMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserEmailEntity toDomain(UserEmail form) {
        return modelMapper.map(form, UserEmailEntity.class);
    }

    public UserEmail toForm(UserEmailEntity entity) {
        return modelMapper.map(entity, UserEmail.class);
    }
}