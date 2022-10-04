package ericauction.ericaution.interfaces.mapper.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.domain.request.test.TestSaveRequestDto;
import ericauction.ericaution.domain.response.test.TestResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TestMapper {

    //RequestDto to Entity Mapper
    public TestEntity testSaveRequestToTestEntity(TestSaveRequestDto testRequest) {
        return TestEntity.builder()
                .name(testRequest.getName())
                .age(testRequest.getAge())
                .build();
    }



    //Entity to ResponseDto Mapper

    public TestResponseDto testEntityToTestUpdateResponse(TestEntity testEntity){
        return TestResponseDto.builder()
                .id(testEntity.getId())
                .createdAt(testEntity.getCreatedAt())
                .lastModifiedAt(testEntity.getLastModifiedAt())
                .name(testEntity.getName())
                .age(testEntity.getAge())
                .build();
    }

    public TestResponseDto testEntityToResponseDto(TestEntity testEntity){
        return TestResponseDto.builder()
                .id(testEntity.getId())
                .createdAt(testEntity.getCreatedAt())
                .lastModifiedAt(testEntity.getLastModifiedAt())
                .name(testEntity.getName())
                .age(testEntity.getAge())
                .build();
    }
}
