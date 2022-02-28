package dddspring.infra.hibernate;

import dddspring.domain.referral.Referral;
import dddspring.domain.referral.ReferralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public final class ReferralMysqlRepository implements ReferralRepository {

    @Autowired
    private ReferralJpaRepository referralJpaRepository;

    @Override
    public List<Referral> all() {
        return Collections.emptyList();
    }

    @Override
    public void save(Referral referral) {

    }
}
