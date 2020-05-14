package com.crm.apis.services.directory.users.repositories;

import com.crm.apis.services.directory.users.domains.UserAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserAddressRepository.
 *
 * @author PoleData.
 */
@Repository
public interface UserAddressRepository extends JpaRepository<UserAddressEntity, Long> {

}