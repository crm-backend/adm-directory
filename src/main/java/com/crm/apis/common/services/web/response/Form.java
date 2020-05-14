package com.crm.apis.common.services.web.response;

import lombok.Data;

import java.util.Date;

@Data
public abstract class Form implements IForm {

    private static final long serialVersionUID = 1L;
    
    private Date startAt;

    private Date endAt;

    private boolean deleted;

    private Long version;

    private Date createdDate;

    private Date updatedAt;

}
