package com.ddd.spring.domain.referral;

import com.ddd.spring.common.Assertion;

public class Referral extends Assertion {

    private ReferralId id;
    
    private Double approvedValue;

    public Referral(Double approvedValue) {
        this.approvedValue = approvedValue;
    }

    public void snapshot(ReferralMemento memento) {
        memento.setId(5l);
        memento.setApprovedValue(this.approvedValue);
    }

    public static Referral restore(ReferralMemento memento) {
        Referral referral = new Referral(memento.getApprovedValue());
        return referral;
    }

    public Long getId() {
        return 5l;
    }
}
