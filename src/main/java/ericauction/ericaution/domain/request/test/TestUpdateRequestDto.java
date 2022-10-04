package ericauction.ericaution.domain.request.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestUpdateRequestDto {
    private String name;
    private int age;

    @Builder
    public TestUpdateRequestDto(String name, int age){
        this.name = name;
        this.age = age;
    }
}
