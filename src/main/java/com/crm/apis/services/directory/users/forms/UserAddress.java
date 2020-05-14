package com.crm.apis.services.directory.users.forms;

import com.crm.apis.common.services.web.response.Form;
import lombok.Data;

/**
 * UserAddress object in Directory API.
 *
 * @author PoleData.
 */

@Data
public class UserAddress extends Form {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String countryCode;

    private String extendedAddress;

    private boolean primary;

    private String locality;

    private String poBox;

    private String postalCode;

    private String regionCode;

    private String streetAddress;

    private String typeCode;

}