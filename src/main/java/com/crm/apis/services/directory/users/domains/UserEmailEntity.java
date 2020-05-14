package com.crm.apis.services.directory.users.domains;

import com.crm.apis.common.services.domain.Domain;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * UserEmail object in Directory API.
 *
 * @author PoleData.
 */

@Data
@Entity
@Table(name = "adm_user_email")
public class UserEmailEntity extends Domain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk", insertable = true, updatable = true, nullable = false)
    private UserEntity user;

    @Column(name = "user_fk", insertable = false, updatable = false)
    private Long userId;

    private String email;

    private String typeCode;

    @Type(type="yes_no")
    private boolean primaire;

    public UserEmailEntity() {
        super();
    }
    public UserEmailEntity(String email, UserEntity user, boolean primaire) {
        this.email = email;
        this.user = user;
        this.primaire = primaire;
    }
}