package com.crm.apis.services.directory.users.forms;

import com.crm.apis.common.services.web.response.Form;
import lombok.Data;

import java.util.List;

@Data
public class User extends Form {

    private Long id;

    private String primaryEmail;

    private String givenName;

    private String familyName;

    private boolean suspended;

    private String password;

    private String hashFunction;

    private boolean changePasswordAtNextLogin;

    private boolean ipWhitelisted;

    private boolean isAdmin;

    private boolean isDelegatedAdmin;


    private List<UserEmail> emails;

    private List<UserAddress> addresses;

    private List<UserExternalId> externalIds;

}
