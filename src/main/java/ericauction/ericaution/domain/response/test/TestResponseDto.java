package ericauction.ericaution.domain.response.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
public class TestResponseDto {
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private String name;
    private int age;

//    public TestResponseDto(TestEntity testEntity){
//        this.id = testEntity.getId();
//        this.createdAt = testEntity.getCreatedAt();
//        this.lastModifiedAt = testEntity.getLastModifiedAt();
//        this.name = testEntity.getName();
//        this.age = testEntity.getAge();
//    }
}
