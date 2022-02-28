package dddspring.domain.referral;

import dddspring.common.FilterCriteria;
import dddspring.common.SpecificationBuilder;
import dddspring.infra.hibernate.ReferralModel;
import org.springframework.data.jpa.domain.Specification;

public class ReferralSpecificationBuilder extends SpecificationBuilder {

    @Override
    protected Specification<ReferralModel> getNewInstance(FilterCriteria filterCriteria) {
        return new ReferralSpecification(filterCriteria);
    }
}
