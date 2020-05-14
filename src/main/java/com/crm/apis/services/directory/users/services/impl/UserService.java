package com.crm.apis.services.directory.users.services.impl;

import com.crm.apis.common.services.exceptions.EntityType;
import com.crm.apis.common.services.exceptions.ExceptionType;
import com.crm.apis.common.services.init.CommonService;
import com.crm.apis.common.services.web.response.query.Pagin;
import com.crm.apis.services.directory.users.domains.UserAddressEntity;
import com.crm.apis.services.directory.users.domains.UserEmailEntity;
import com.crm.apis.services.directory.users.domains.UserEntity;
import com.crm.apis.services.directory.users.forms.User;
import com.crm.apis.services.directory.users.forms.UserAddress;
import com.crm.apis.services.directory.users.forms.UserEmail;
import com.crm.apis.services.directory.users.forms.UserFilter;
import com.crm.apis.services.directory.users.mappers.UserAddressMapper;
import com.crm.apis.services.directory.users.mappers.UserEmailMapper;
import com.crm.apis.services.directory.users.mappers.UserMapper;
import com.crm.apis.services.directory.users.repositories.UserAddressRepository;
import com.crm.apis.services.directory.users.repositories.UserEmailRepository;
import com.crm.apis.services.directory.users.repositories.UserRepository;
import com.crm.apis.services.directory.users.repositories.UserFilterRepository;
import com.crm.apis.services.directory.users.rules.UserAddressRules;
import com.crm.apis.services.directory.users.rules.UserEmailRules;
import com.crm.apis.services.directory.users.rules.UserRules;
import com.crm.apis.services.directory.users.services.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * UserService.
 *
 * @author PoleData.
 */
@Service
@Slf4j
@Transactional
public class UserService extends CommonService implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserEmailMapper userEmailMapper;
    private final UserRules userRules;
    private final UserEmailRules userEmailRules;
    private final UserFilterRepository userFilterRepository;
    private final UserEmailRepository userEmailRepository;

    private final UserAddressRepository userAddressRepository;
    private final UserAddressMapper userAddressMapper;
    private final UserAddressRules userAddressRules;

    public UserService(UserRepository userRepository, UserMapper userMapper, UserRules userRules, UserFilterRepository userFilterRepository,
                       UserEmailMapper userEmailMapper,
                       UserEmailRules userEmailRules, UserEmailRepository userEmailRepository,
                        UserAddressRepository userAddressRepository,  UserAddressMapper userAddressMapper,
                       UserAddressRules userAddressRules) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userRules = userRules;
        this.userFilterRepository = userFilterRepository;
        this.userEmailMapper = userEmailMapper;
        this.userEmailRules = userEmailRules;
        this.userEmailRepository = userEmailRepository;
        this.userAddressRepository = userAddressRepository;
        this.userAddressMapper = userAddressMapper;
        this.userAddressRules = userAddressRules;
    }

    @Override
    public User getUserById(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return userMapper.toForm(user.get());
        }
        throw exception(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, userId.toString());
    }

    @Override
    public Pagin<User> find(UserFilter filter, Pageable pageable) {
        Page<UserEntity> result = userFilterRepository.find(filter,pageable);
        List<User> list = result.getContent().stream().map(user -> userMapper.toForm(user)).collect(Collectors.toList());
        return new Pagin<User>(result.getTotalPages(), result.getTotalElements(), list);
    }

    @Override
    public User createNewUser(User user) {
        UserEntity entity = userMapper.toDomain(user);
        userRules.create(entity);
        userRepository.save(entity);
        return userMapper.toForm(entity);
    }

    @Override
    public User updateUser(User user) {
        UserEntity entity = userRules.update(user);
        userRepository.save(entity);
        return userMapper.toForm(entity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).map(u -> {
            u.setDeleted(true);
            return userRepository.save(u);
        }).orElseThrow(() -> {
            throw exception(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND, id.toString());
        });
    }


    @Override
    public UserEmail addEmail(UserEmail userEmail) {
        UserEmailEntity entity = userEmailMapper.toDomain(userEmail);
        userEmailRules.create(entity);
        userEmailRepository.save(entity);
        return userEmailMapper.toForm(entity);
    }

    @Override
    public UserAddress addAddress(UserAddress userAddress) {
        UserAddressEntity entity = userAddressMapper.toDomain(userAddress);
        userAddressRules.create(entity);
        userAddressRepository.save(entity);
        return userAddressMapper.toForm(entity);
    }

}