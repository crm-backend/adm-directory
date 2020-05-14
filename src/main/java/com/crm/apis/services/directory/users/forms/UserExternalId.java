package com.crm.apis.services.directory.users.forms;

import com.crm.apis.common.services.web.response.Form;
import lombok.Data;

/**
 * UserExternalId object in Directory API.
 *
 * @author PoleData.
 */

@Data
public class UserExternalId extends Form {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String value;

    private String typeCode;

}