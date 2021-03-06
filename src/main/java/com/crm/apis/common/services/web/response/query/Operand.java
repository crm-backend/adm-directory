package com.crm.apis.common.services.web.response.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Operand {
    private String operand;
    private List<Filter> filters = new ArrayList<>(0);
    private final List<Operand> operands = new ArrayList<>(0);
}
