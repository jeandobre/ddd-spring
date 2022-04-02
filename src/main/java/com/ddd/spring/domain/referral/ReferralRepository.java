package com.ddd.spring.domain.referral;

import java.util.List;

public interface ReferralRepository {
    void persist(Referral referral);

    Referral retrieve(ReferralId id);
}
