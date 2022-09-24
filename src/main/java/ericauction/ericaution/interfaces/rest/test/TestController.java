package ericauction.ericaution.interfaces.rest.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.domain.request.test.TestSaveRequestDto;
import ericauction.ericaution.domain.request.test.TestUpdateRequestDto;
import ericauction.ericaution.domain.response.TestResponseDto;
import ericauction.ericaution.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/")
    public TestEntity save(@RequestBody TestSaveRequestDto testSaveRequestDto) {
        TestEntity testEntity = testService.saveTestEntity(testSaveRequestDto);
        return testEntity;
    }

    @PutMapping("/{id}")
    public TestResponseDto update(@PathVariable Long id, @RequestBody TestUpdateRequestDto testUpdateRequestDto){
        TestResponseDto updatedResponseDto = testService.updateTestEntity(id, testUpdateRequestDto);
        return updatedResponseDto;
    }

    @GetMapping("/{id}")
    public TestResponseDto findById(@PathVariable Long id){
        return testService.findById(id);
    }



}
