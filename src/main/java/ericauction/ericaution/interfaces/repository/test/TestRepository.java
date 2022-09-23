package ericauction.ericaution.interfaces.repository.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
}
