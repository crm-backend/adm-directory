package com.crm.apis.services.directory.users.domains;

import com.crm.apis.common.services.domain.Domain;
import lombok.Data;

import javax.persistence.*;

/**
 * UserExternalId object in Directory API.
 *
 * @author PoleData.
 */

@Data
@Entity
@Table(name = "adm_user_ids")
public class UserExternalIdEntity extends Domain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk", insertable = true, updatable = true, nullable = false)
    private UserEntity user;

    @Column(name = "user_fk", insertable = false, updatable = false)
    private Long userId;

    private String value;

    private String typeCode;

}