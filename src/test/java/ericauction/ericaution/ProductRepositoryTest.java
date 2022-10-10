package ericauction.ericaution;

import ericauction.ericaution.domain.persistence.auction.ProductEntity;
import ericauction.ericaution.interfaces.repository.auction.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @AfterEach
    public void cleanUp(){
        productRepository.deleteAll();}

    @Test
    @DisplayName("Repository save & read test")
    public void saveAndReadProductEntity(){
        String title = "맥북 프로 16인치 노트북 팔아요";
        String category = "notebook";
        String detailCategory = "macbook pro 16";
        String productState = "중고상품";
        int immediatePurchasePrice = 1800000;
        int lowestPriceAuction = 1000000;
        String contents = "1년 정도 사용한 맥북 프로 16인치 입니다. 깔끔하게 사용해서 생활기스도 없습니다.";

        productRepository.save(ProductEntity.builder()
                .title(title)
                .category(category)
                .detailCategory(detailCategory)
                .productState(productState)
                .immediatePurchasePrice(immediatePurchasePrice)
                .lowestPriceAuction(lowestPriceAuction)
                .contents(contents)
                .build());

        List<ProductEntity> productEntityList = productRepository.findAll();

        ProductEntity productEntity = productEntityList.get(0);

        assertThat(productEntity.getTitle()).isEqualTo(title);
        assertThat(productEntity.getCategory()).isEqualTo(category);
        assertThat(productEntity.getDetailCategory()).isEqualTo(detailCategory);
        assertThat(productEntity.getImmediatePurchasePrice()).isEqualTo(immediatePurchasePrice);
        assertThat(productEntity.getLowestPriceAuction()).isEqualTo(lowestPriceAuction);
        assertThat(productEntity.getContents()).isEqualTo(contents);
    }
}
