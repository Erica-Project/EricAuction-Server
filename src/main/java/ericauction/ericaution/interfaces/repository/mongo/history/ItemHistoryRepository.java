package ericauction.ericaution.interfaces.repository.mongo.history;

import ericauction.ericaution.domain.mongo.history.ItemHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemHistoryRepository extends MongoRepository<ItemHistory, String> {
}
