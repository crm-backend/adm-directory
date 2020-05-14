package com.crm.apis.services.directory.users.forms;

import com.crm.apis.common.services.web.response.FilterForm;
import com.crm.apis.common.services.web.response.Form;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserFilter extends FilterForm {

    private Long id;

    private String primaryEmail;

    private String givenName;

    private String familyName;

    private Boolean suspended;
    private Date suspendedAt;
    private Date suspendedForm;
    private Date suspendedTo;

    private Boolean enabled;
    private Date enabledAt;
    private Date enabledAtFrom;
    private Date enabledAtTo;

    private Boolean ipWhitelisted;

    private Boolean isAdmin;

    private Boolean isDelegatedAdmin;


}
