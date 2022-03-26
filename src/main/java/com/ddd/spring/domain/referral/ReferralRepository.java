package com.ddd.spring.domain.referral;

import java.util.List;

public interface ReferralRepository {

    List<Referral> all();

    void save(Referral referral);
}
