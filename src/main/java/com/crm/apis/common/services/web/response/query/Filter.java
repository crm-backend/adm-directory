package com.crm.apis.common.services.web.response.query;

import lombok.Data;

@Data
public class Filter {
    private String key;
    private String op;
    private Object value;
    private Operand operand;
    private String type;
}
