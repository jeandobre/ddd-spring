package com.ddd.spring.application.referral;

import com.ddd.spring.common.ResponseEntityHeader;
import com.ddd.spring.infra.referral.JpaReferralRepository;
import com.ddd.spring.infra.referral.ReferralModel;
import com.ddd.spring.infra.referral.SpecificationReferralModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/referrals")
public class RestControllerReferral {

    private final JpaReferralRepository repository;

    public RestControllerReferral(JpaReferralRepository repository) {
        this.repository = repository;
    }

    //sort=name,desc&sort=code,desc
    //filter=( firstName:john OR firstName:tom ) AND age>22
    //=firstName:jo*;age<25;
    @GetMapping(produces = "application/json")
    ResponseEntity<Object> list(
        Pageable pageable,
        @RequestParam(value = "filter", defaultValue = "") String filter
    ) {

        Specification<ReferralModel> spec = new SpecificationReferralModel(filter).build();

        try {
            Page<ReferralModel> pageReferral = repository.findAll(spec, pageable);

            return ResponseEntityHeader.bodyAndHeaders(pageReferral);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
