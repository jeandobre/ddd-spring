package dddspring.infra.hibernate;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReferralJpaRepository extends PagingAndSortingRepository<ReferralModel, Long>,
        JpaSpecificationExecutor<ReferralModel> {
}
