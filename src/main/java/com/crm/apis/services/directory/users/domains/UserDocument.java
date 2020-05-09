package com.crm.apis.services.directory.users.domains;

public class UserDocument {

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
