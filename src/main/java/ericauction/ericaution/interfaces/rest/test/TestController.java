package ericauction.ericaution.interfaces.rest.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.domain.request.test.TestRequestDto;
import ericauction.ericaution.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/")
    public TestEntity test(@RequestBody TestRequestDto testRequestDto) {
        TestEntity testEntity = testService.saveTestEntity(testRequestDto);
        return testEntity;
    }
}
