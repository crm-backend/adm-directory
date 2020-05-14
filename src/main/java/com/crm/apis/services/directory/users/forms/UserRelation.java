package com.crm.apis.services.directory.users.forms;

import com.crm.apis.common.services.web.response.Form;
import lombok.Data;

/**
 * UserRelation object in Directory API.
 *
 * @author PoleData.
 */

@Data
public class UserRelation extends Form {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long parentId;

    private Long childId;

    private String typeCode;

}