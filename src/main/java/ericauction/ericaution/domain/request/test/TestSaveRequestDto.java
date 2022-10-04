package ericauction.ericaution.domain.request.test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestSaveRequestDto {
    private String name;
    private int age;

//    @Builder
//    TestSaveRequestDto(String name, int age){
//        this.name = name;
//        this.age = age;
//    }
}
