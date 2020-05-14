package com.crm.apis.services.directory.users.domains;

import com.crm.apis.common.services.domain.Domain;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

/**
 * UserAddress object in Directory API.
 *
 * @author PoleData.
 */

@Data
@Entity
@Table(name = "adm_user_adr")
public class UserAddressEntity extends Domain {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_fk", insertable = true, updatable = true, nullable = false)
    private UserEntity user;

    @Column(name = "user_fk", insertable = false, updatable = false)
    private Long userId;

    private String countryCode;

    private String extendedAddress;

    @Type(type="yes_no")
    private boolean primaire;

    private String locality;

    private String poBox;

    private String postalCode;

    private String regionCode;

    private String streetAddress;

    private String typeCode;

}