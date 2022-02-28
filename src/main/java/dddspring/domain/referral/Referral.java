package dddspring.domain.referral;

public class Referral {

    private Long id;

    private Double approvedValue;

    public Referral(Double approvedValue) {
        this.approvedValue = approvedValue;
    }
}
