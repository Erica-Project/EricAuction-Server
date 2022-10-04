package ericauction.ericaution.domain.persistence.test;

import ericauction.ericaution.domain.persistence.base.AuditableEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class TestEntity extends AuditableEntity {

    private String name;
    private int age;

    @Builder
    public TestEntity(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void update(String name, int age){
        this.name = name;
        this.age = age;
    }
}
