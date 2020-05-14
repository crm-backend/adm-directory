package com.crm.apis.services.directory.users.services;


import com.crm.apis.common.services.web.response.query.Pagin;
import com.crm.apis.common.services.web.response.query.RequestFilter;
import com.crm.apis.services.directory.users.forms.User;
import com.crm.apis.services.directory.users.forms.UserAddress;
import com.crm.apis.services.directory.users.forms.UserEmail;
import com.crm.apis.services.directory.users.forms.UserFilter;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    User getUserById(Long id);
    Pagin<User> find(UserFilter user, Pageable pageable) ;
    User createNewUser(User user) ;
    User updateUser(User user) ;
    void deleteUser(Long id) ;

    UserEmail addEmail(UserEmail userEmail);

    UserAddress addAddress(UserAddress userAddress);
}
