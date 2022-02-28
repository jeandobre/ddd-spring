package dddspring.infra.hibernate;

import javax.persistence.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "referral")
@Getter
@Setter
public class ReferralModel {

    @Id
    private Long id;

    private String ip;

    private Boolean completedAnalysis;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private Double valueRequested;

    @ManyToOne
    @JoinColumn(name = "farmer_id", referencedColumnName = "id")
    private FarmerModel farmer;
}
