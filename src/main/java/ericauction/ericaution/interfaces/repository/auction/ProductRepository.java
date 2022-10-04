package ericauction.ericaution.interfaces.repository.auction;

import ericauction.ericaution.domain.persistence.auction.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
