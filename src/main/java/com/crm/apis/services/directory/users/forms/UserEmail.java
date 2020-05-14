package com.crm.apis.services.directory.users.forms;

import com.crm.apis.common.services.web.response.Form;
import lombok.Data;

/**
 * UserEmail object in Directory API.
 *
 * @author PoleData.
 */

@Data
public class UserEmail extends Form {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long userId;

    private String email;

    private String typeCode;

    private boolean primary;
}