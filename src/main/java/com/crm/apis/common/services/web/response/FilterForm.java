package com.crm.apis.common.services.web.response;

import lombok.Data;

import java.util.Date;

@Data
public abstract class FilterForm implements IForm {

    private static final long serialVersionUID = 1L;
    
    private Date startAt;

    private Date endAt;

    private Date createdDate;
    private Date createdDateForm;
    private Date createdDateTo;



}
