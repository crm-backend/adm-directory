package com.crm.apis.services.directory.users.domains;

import com.crm.apis.common.services.domain.Domain;
import lombok.Data;

import javax.persistence.*;

/**
 * UserRelation object in Directory API.
 *
 * @author PoleData.
 */

@Data
@Entity
@Table(name = "user_relation")
public class UserRelationEntity extends Domain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_fk", insertable = true, updatable = true, nullable = false)
    private UserEntity parent;

    @Column(name = "parent_fk", insertable = false, updatable = false)
    private Long parentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "child_fk", insertable = true, updatable = true, nullable = false)
    private UserEntity child;

    @Column(name = "child_fk", insertable = false, updatable = false)
    private Long childId;

    private String typeCode;


}