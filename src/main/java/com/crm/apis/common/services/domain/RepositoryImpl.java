package com.crm.apis.common.services.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class RepositoryImpl {

    @PersistenceContext
    protected EntityManager entityManager;
}
