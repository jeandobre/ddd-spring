package dddspring.domain.referral;

import dddspring.common.FilterCriteria;
import dddspring.infra.hibernate.ReferralModel;
import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public final class ReferralSpecification implements Specification<ReferralModel> {

    private final FilterCriteria criteria;

    public ReferralSpecification(FilterCriteria criteria) {
        this.criteria = criteria;
    }

    public Predicate toPredicate(final Root<ReferralModel> root,
                                 final CriteriaQuery<?> query,
                                 final CriteriaBuilder builder) {
        return criteria.getPredicateByBuilder(root, builder);
    }

    public static Specification<ReferralModel> farmer(Long farmerId) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder
                .equal(root.join("farmer").get("id"), farmerId);
    }
}