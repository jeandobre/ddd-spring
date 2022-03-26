package com.ddd.spring.infra.referral;

import com.ddd.spring.common.SpecificationBuilder;
import com.ddd.spring.common.FilterCriteria;
import org.springframework.data.jpa.domain.Specification;

public final class SpecificationReferralModel extends SpecificationBuilder<ReferralModel> {

    public SpecificationReferralModel(String filter) {
        super(filter);
    }

    @Override
    protected Specification<ReferralModel> getNewInstance(FilterCriteria filterCriteria) {
        return custom(filterCriteria);
    }

    public static Specification<ReferralModel> custom(FilterCriteria criteria) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteria.getPredicateByBuilder(root, criteriaBuilder);
    }

    public static Specification<ReferralModel> farmer(Long farmerId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(root.join("farmer").get("id"), farmerId);
    }

}