package com.crm.apis.services.directory.users.repositories;

import com.crm.apis.services.directory.users.domains.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepository.
 *
 * @author PoleData.
 */
@Repository
public interface UserExternalIdRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByPrimaryEmail(String primaryEmail);

}