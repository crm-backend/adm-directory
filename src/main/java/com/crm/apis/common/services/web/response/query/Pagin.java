package com.crm.apis.common.services.web.response.query;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Pagin
 * @param <T>
 */
@Data
public class Pagin<T> implements Serializable {

    private int totalPages;

    private long totalElements;

    private List<T> items;

    public Pagin(int totalPages, long totalElements, List<T> items) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.items = items;
    }
}
