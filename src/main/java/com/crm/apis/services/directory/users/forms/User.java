package com.crm.apis.services.directory.users.forms;

public class User {

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

}
