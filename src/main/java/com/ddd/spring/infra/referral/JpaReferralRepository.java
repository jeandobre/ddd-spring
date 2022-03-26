package com.ddd.spring.infra.referral;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JpaReferralRepository extends PagingAndSortingRepository<ReferralModel, Long>,
        JpaSpecificationExecutor<ReferralModel> {
}
