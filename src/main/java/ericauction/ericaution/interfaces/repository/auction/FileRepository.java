package ericauction.ericaution.interfaces.repository.auction;

import ericauction.ericaution.domain.persistence.auction.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity,Long> {

}
