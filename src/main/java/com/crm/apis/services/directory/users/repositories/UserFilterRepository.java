package com.crm.apis.services.directory.users.repositories;

import com.crm.apis.services.directory.users.domains.UserEntity;
import com.crm.apis.services.directory.users.forms.User;
import com.crm.apis.services.directory.users.forms.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRepository.
 *
 * @author PoleData.
 */
public interface UserFilterRepository  {

    Page<UserEntity> find(UserFilter filter, Pageable pageable);
}