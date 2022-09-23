package ericauction.ericaution.service.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.domain.request.test.TestRequestDto;
import ericauction.ericaution.interfaces.mapper.test.TestMapper;
import ericauction.ericaution.interfaces.repository.test.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestService {

    private final TestRepository testRepository;
    private final TestMapper testMapper;

    @Transactional  //Commit test
    public TestEntity saveTestEntity(TestRequestDto testDto) {
        TestEntity testEntity = testMapper.testRequestToTestEntity(testDto);
        TestEntity savedEntity = testRepository.save(testEntity);
        return savedEntity;
    }
}
