package com.crm.apis.services.directory.users.mappers;

import com.crm.apis.services.directory.users.domains.UserEmailEntity;
import com.crm.apis.services.directory.users.domains.UserEntity;
import com.crm.apis.services.directory.users.forms.User;
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
public class UserMapper  {

    private ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserEntity toDomain(User user) {
        UserEntity entity = modelMapper.map(user, UserEntity.class);
        for(UserEmailEntity e : entity.getEmails()) {
            e.setUser(entity);
        }
        System.out.println(entity);
        return entity;
    }

    public User toForm(UserEntity userDocument) {
        return modelMapper.map(userDocument, User.class);
    }
}