package com.crm.apis.services.directory.users.repositories;

import com.crm.apis.services.directory.users.domains.UserEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserRepository.
 *
 * @author PoleData.
 */
@Repository
public interface UserEmailRepository extends JpaRepository<UserEmailEntity, String> {

    @Query("select count(e) from UserEmailEntity e where e.userId = ?1 and e.email = ?2")
    long countUserIdAndEmail(Long userId,String email);

}