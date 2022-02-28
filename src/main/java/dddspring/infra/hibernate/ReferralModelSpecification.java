package dddspring.infra.hibernate;

import dddspring.common.FilterCriteria;
import dddspring.common.SpecificationBuilder;
import org.springframework.data.jpa.domain.Specification;

public final class ReferralModelSpecification extends SpecificationBuilder {

    public ReferralModelSpecification(String filter) {
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