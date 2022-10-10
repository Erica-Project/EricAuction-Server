package ericauction.ericaution.interfaces.mapper.auction;

import ericauction.ericaution.domain.persistence.auction.ProductEntity;
import ericauction.ericaution.domain.request.auction.ProductSaveRequestDto;
import ericauction.ericaution.domain.response.auction.ProductResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    //RequestDto ro Entity Mapper
    public ProductEntity productSaveRequestToProductEntity(ProductSaveRequestDto productSaveRequestDto){
        return ProductEntity.builder()
                .title(productSaveRequestDto.getTitle())
                .category(productSaveRequestDto.getCategory())
                .detailCategory(productSaveRequestDto.getDetailCategory())
                .productState(productSaveRequestDto.getProductState())
                .immediatePurchasePrice(productSaveRequestDto.getImmediatePurchasePrice())
                .lowestPriceAuction(productSaveRequestDto.getLowestPriceAuction())
                .contents(productSaveRequestDto.getContents())
                .build();
    }

    // Entity to ResponseDto Mapper
    public ProductResponseDto productEntityToProductResponseDto(ProductEntity productEntity){
        return ProductResponseDto.builder()
                .id(productEntity.getId())
                .createdAt(productEntity.getCreatedAt())
                .lastModifiedAt(productEntity.getLastModifiedAt())
                .title(productEntity.getTitle())
                .category(productEntity.getCategory())
                .detailCategory(productEntity.getDetailCategory())
                .productState(productEntity.getProductState())
                .immediatePurchasePrice(productEntity.getImmediatePurchasePrice())
                .lowestPriceAuction(productEntity.getLowestPriceAuction())
                .contents(productEntity.getContents())
                .build();
    }
}
