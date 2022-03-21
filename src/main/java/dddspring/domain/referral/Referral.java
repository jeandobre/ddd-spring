package dddspring.domain.referral;

import java.util.UUID;

import dddspring.common.Assertion;

public class Referral extends Assertion {

    private Long id;
    
    private UUID uuid;

    private Double approvedValue;

    public Referral(Double approvedValue) {
        this.approvedValue = approvedValue;
    }
    
    public Long id() {
    	return this.id;
    }
    
    public Double approvedValue() {
    	return this.approvedValue;
    }
}
