package ericauction.ericaution;

import ericauction.ericaution.domain.persistence.test.TestEntity;
import ericauction.ericaution.interfaces.repository.test.TestRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

@SpringBootTest
public class TestRepositoryTest {
    @Autowired
    TestRepository testRepository;

    @AfterEach
    public void cleanUp(){
        testRepository.deleteAll();
    }

    @Test
    @DisplayName("Repository save & read test") //build 환경이 gradle인 경우 DisplayName 지원 안해준다...
    public void saveAndReadTestEntity(){
        String name = "테스트 이름";
        int age = 26;

        testRepository.save(TestEntity.builder().name(name).age(age).build());

        List<TestEntity> testEntityList = testRepository.findAll();

        TestEntity testEntity = testEntityList.get(0);

        assertThat(testEntity.getName()).isEqualTo(name);
        assertThat(testEntity.getAge()).isEqualTo(age);
    }


}
