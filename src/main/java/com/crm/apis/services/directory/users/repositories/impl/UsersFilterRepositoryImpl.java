package com.crm.apis.services.directory.users.repositories.impl;

import com.crm.apis.common.services.domain.RepositoryImpl;
import com.crm.apis.common.services.utils.ValidatorUtils;
import com.crm.apis.services.directory.users.domains.UserEntity;
import com.crm.apis.services.directory.users.forms.UserFilter;
import com.crm.apis.services.directory.users.repositories.UserFilterRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * UsersRepositoryImpl.
 *
 * @author PoleData.
 */
@Service
public class UsersFilterRepositoryImpl extends RepositoryImpl implements UserFilterRepository {

    @Override
    public Page<UserEntity> find(UserFilter filter, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(UserEntity.class);
        Root userRoot = query.from(UserEntity.class);
        List<Predicate> filterPredicates = new ArrayList<>(0);

        if (ValidatorUtils.isNotEmpty(filter.getPrimaryEmail())) {
            filterPredicates.add(cb.equal(userRoot.get("primaryEmail"), filter.getPrimaryEmail()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getEnabled())) {
            filterPredicates.add(cb.equal(userRoot.get("enabled"), filter.getEnabled()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getEnabledAt())) {
            filterPredicates.add(cb.equal(userRoot.get("enabledAt"), filter.getEnabledAt()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getEnabledAtFrom())) {
            filterPredicates.add(cb.greaterThanOrEqualTo(userRoot.get("enabledAt"), filter.getEnabledAtFrom()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getEnabledAtTo())) {
            filterPredicates.add(cb.lessThanOrEqualTo(userRoot.get("enabledAt"), filter.getEnabledAtTo()));
        }

        if (ValidatorUtils.isNotEmpty(filter.getSuspended())) {
            filterPredicates.add(cb.equal(userRoot.get("suspended"), filter.getSuspended()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getSuspendedAt())) {
            filterPredicates.add(cb.equal(userRoot.get("suspendedAt"), filter.getSuspendedAt()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getSuspendedForm())) {
            filterPredicates.add(cb.greaterThanOrEqualTo(userRoot.get("suspendedAt"), filter.getSuspendedForm()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getSuspendedTo())) {
            filterPredicates.add(cb.lessThanOrEqualTo(userRoot.get("suspendedAt"), filter.getSuspendedTo()));
        }

        if (ValidatorUtils.isNotEmpty(filter.getIsAdmin())) {
            filterPredicates.add(cb.equal(userRoot.get("isAdmin"), filter.getIsAdmin()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getIsDelegatedAdmin())) {
            filterPredicates.add(cb.equal(userRoot.get("isDelegatedAdmin"), filter.getIsDelegatedAdmin()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getCreatedDate())) {
            filterPredicates.add(cb.equal(userRoot.get("createdDate"), filter.getCreatedDate()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getCreatedDateForm())) {
            filterPredicates.add(cb.greaterThanOrEqualTo(userRoot.get("createdDate"), filter.getCreatedDateForm()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getIpWhitelisted())) {
            filterPredicates.add(cb.equal(userRoot.get("ipWhitelisted"), filter.getIpWhitelisted()));
        }
        if (ValidatorUtils.isNotEmpty(filter.getId())) {
            filterPredicates.add(cb.equal(userRoot.get("id"), filter.getId()));
        }
        query.where(cb.and(filterPredicates.toArray(new Predicate[0])));

        TypedQuery q = entityManager.createQuery(query);
        q.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        q.setMaxResults(pageable.getPageSize());
        return new PageImpl<>(q.getResultList(), pageable,entityManager.createQuery(query).getResultList().size());

    }
}