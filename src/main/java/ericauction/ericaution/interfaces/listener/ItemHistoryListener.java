package ericauction.ericaution.interfaces.listener;

import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class ItemHistoryListener {

    @PostPersist
    public void postUpdate(Object Item) {
        /*
            todo
         */
    }
}
