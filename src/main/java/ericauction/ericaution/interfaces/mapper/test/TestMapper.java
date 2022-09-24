package ericauction.ericaution.interfaces.mapper.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.domain.request.test.TestSaveRequestDto;
import ericauction.ericaution.domain.request.test.TestUpdateRequestDto;
import org.springframework.stereotype.Component;

@Component
public class TestMapper {
    public TestEntity testSaveRequestToTestEntity(TestSaveRequestDto testRequest) {
        return TestEntity.builder()
                .name(testRequest.getName())
                .age(testRequest.getAge())
                .build();
    }
}
