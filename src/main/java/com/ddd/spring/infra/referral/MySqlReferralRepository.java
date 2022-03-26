package com.ddd.spring.infra.referral;

import com.ddd.spring.domain.referral.Referral;
import com.ddd.spring.domain.referral.ReferralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public final class MySqlReferralRepository implements ReferralRepository {

    @Autowired
    private JpaReferralRepository jpaReferralRepository;

    @Override
    public List<Referral> all() {
        return Collections.emptyList();
    }

    @Override
    public void save(Referral referral) {
        ReferralModel model = new ReferralModel();
        if(referral.id() != null) {
            Optional<ReferralModel> optModel = jpaReferralRepository.findById(referral.id());
            if(optModel.isPresent())
                model = optModel.get();
        }
        model.setValueRequested(referral.approvedValue());

        jpaReferralRepository.save(model);
    }
}
