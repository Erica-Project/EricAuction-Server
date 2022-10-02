package ericauction.ericaution.domain.persistence.auction;

import ericauction.ericaution.domain.persistence.base.AuditableEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ProductEntity extends AuditableEntity {
    //    private String images;    // 상품 이미지 정보 저장
    private String title;
    private String category;
    private String detailCategory;
    private String productState;
    private int immediatePurchasePrice;
    private int lowestPriceAuction;
    private String contents;

    @Builder
    public ProductEntity(String title, String category, String detailCategory, String productState, int immediatePurchasePrice, int lowestPriceAuction, String contents) {
        this.title = title;
        this.category = category;
        this.detailCategory = detailCategory;
        this.productState = productState;
        this.immediatePurchasePrice = immediatePurchasePrice;
        this.lowestPriceAuction = lowestPriceAuction;
        this.contents = contents;
    }

}
