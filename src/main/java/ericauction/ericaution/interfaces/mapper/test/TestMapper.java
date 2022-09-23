package ericauction.ericaution.interfaces.mapper.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.domain.request.test.TestRequestDto;
import org.springframework.stereotype.Component;

@Component
public class TestMapper {
    public TestEntity testRequestToTestEntity(TestRequestDto testRequest) {
        return TestEntity.builder()
                .name(testRequest.getName())
                .age(testRequest.getAge())
                .build();
    }
}
