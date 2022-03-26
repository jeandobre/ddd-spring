package com.ddd.spring.infra.referral;

import javax.persistence.*;
import java.util.Date;

import com.ddd.spring.infra.farmer.FarmerModel;
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
