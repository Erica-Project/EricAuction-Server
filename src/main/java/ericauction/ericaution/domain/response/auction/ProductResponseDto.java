package ericauction.ericaution.domain.response.auction;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ProductResponseDto {
    //    private String images;    // 상품 이미지 정보 저장
    private Long id;
    private LocalDateTime createdAt;
    private LocalDateTime lastModifiedAt;
    private String title;
    private String category;
    private String detailCategory;
    private String productState;
    private int immediatePurchasePrice;
    private int lowestPriceAuction;
    private String contents;
}
