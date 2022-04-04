package com.ddd.spring.infra.referral;

import com.ddd.spring.domain.referral.Referral;
import com.ddd.spring.domain.referral.ReferralId;
import com.ddd.spring.domain.referral.ReferralRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public final class ReferralDao implements ReferralRepository {

    private final JpaReferralRepository jpaReferralRepository;

    public ReferralDao(JpaReferralRepository jpaReferralRepository) {
        this.jpaReferralRepository = jpaReferralRepository;
        System.out.println("ReferralDao created...");
    }

    @Override
    public void persist(Referral referral) {
        ReferralModel model = new ReferralModel();
        if(referral.getId() != null) {
            Optional<ReferralModel> optModel = jpaReferralRepository.findById(referral.getId());
            if(optModel.isPresent())
                model = optModel.get();
        }
        referral.snapshot(model);
        jpaReferralRepository.save(model);
    }

    @Override
    public Referral retrieve(ReferralId id) {
        Optional<ReferralModel> optModel = jpaReferralRepository.findById(5l);
        if(optModel.isPresent()) {
            return Referral.restore(optModel.get());
        }
        return null;
    }
}
