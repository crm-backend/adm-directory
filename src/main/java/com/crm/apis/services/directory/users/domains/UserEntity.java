package com.crm.apis.services.directory.users.domains;

import com.crm.apis.common.services.domain.Domain;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User object in Directory API.
 *
 * @author PoleData.
 */
@Data
@Entity
@Table(name = "adm_user")
@Where(clause = "deleted=false")
public class UserEntity extends Domain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String primaryEmail;

    private String givenName;

    private String familyName;

    @Type(type="yes_no")
    private boolean suspended;

    private Date suspendedAt;

    @Type(type="yes_no")
    private boolean enabled;

    private Date enabledAt;

    private String password;

    private String hashFunction;

    private boolean changePasswordAtNextLogin;

    @Type(type="yes_no")
    private boolean ipWhitelisted;

    private boolean isAdmin;
    private Date isAdminAt;

    private boolean isDelegatedAdmin;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserEmailEntity> emails = new ArrayList<>(0);

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserAddressEntity> addresses = new ArrayList<>(0);

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserExternalIdEntity> externalIds = new ArrayList<>(0);

    @Override
    public String toString() {
        return primaryEmail;
    }
}