package dddspring.application;

import dddspring.common.RegexFilter;
import dddspring.common.ResponseEntityHeader;
import dddspring.infra.hibernate.ReferralJpaRepository;
import dddspring.infra.hibernate.ReferralModel;
import dddspring.infra.hibernate.ReferralModelSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/referrals")
public class ReferralRestController {

    private final ReferralJpaRepository repository;

    public ReferralRestController(ReferralJpaRepository repository) {
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

        Specification<ReferralModel> spec = new ReferralModelSpecification(filter).build();

        try {
            Page<ReferralModel> pageReferral = repository.findAll(spec, pageable);

            return ResponseEntityHeader.bodyAndHeaders(pageReferral);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
