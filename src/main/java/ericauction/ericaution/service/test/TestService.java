package ericauction.ericaution.service.test;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.domain.request.test.TestSaveRequestDto;
import ericauction.ericaution.domain.request.test.TestUpdateRequestDto;
import ericauction.ericaution.domain.response.TestResponseDto;
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
    public TestEntity saveTestEntity(TestSaveRequestDto requestDto) {
        TestEntity testEntity = testMapper.testSaveRequestToTestEntity(requestDto);
        TestEntity savedEntity = testRepository.save(testEntity);
        return savedEntity;
    }

    @Transactional
    public TestResponseDto updateTestEntity(Long id, TestUpdateRequestDto requestDto){
        TestEntity testEntity = testRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 객체는 존재하지 않습니다. id = " + id));
        testEntity.update(requestDto.getName(), requestDto.getAge());
        TestResponseDto updatedResponseDto = testMapper.testEntityToTestUpdateResponse(testEntity);
        return updatedResponseDto;
    }

    public TestResponseDto findById(Long id){
        TestEntity testEntity = testRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 객체는 존재하지 않습니다. id = "+id));
        TestResponseDto resultResponseDto = testMapper.testEntityToResponseDto(testEntity);
        return resultResponseDto;
    }

}
