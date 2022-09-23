package ericauction.ericaution.domain.persistence.test;

import ericauction.ericaution.domain.persistence.base.AuditableEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@Builder
public class TestEntity extends AuditableEntity {
    private String name;
    private int age;
}
