package ericauction.ericaution.domain.mongo.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class PersistableDocument {
    @Id
    private String Id;
}
