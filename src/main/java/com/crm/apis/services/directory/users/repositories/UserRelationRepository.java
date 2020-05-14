package com.crm.apis.services.directory.users.repositories;

import com.crm.apis.services.directory.users.domains.UserRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRelationRepository.
 *
 * @author PoleData.
 */
@Repository
public interface UserRelationRepository extends JpaRepository<UserRelationEntity, Long> {


}