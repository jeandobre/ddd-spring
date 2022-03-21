package dddspring.infra.farmer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farmer")
@Getter
@Setter
public class FarmerModel {

    @Id
    private Long id;

    private String alias;
}
