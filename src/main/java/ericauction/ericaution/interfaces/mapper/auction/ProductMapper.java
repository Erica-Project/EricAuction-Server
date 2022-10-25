package ericauction.ericaution.interfaces.mapper.auction;

import ericauction.ericaution.domain.persistence.auction.ProductEntity;
import ericauction.ericaution.domain.request.auction.ProductSaveRequestDto;
import ericauction.ericaution.domain.response.auction.ProductResponseDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class ProductMapper {

    //RequestDto ro Entity Mapper
    public ProductEntity productSaveRequestToProductEntity(ProductSaveRequestDto productSaveRequestDto){
        ArrayList<String> uriArr = productSaveRequestDto.getImages();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<uriArr.size(); i++){
            sb.append(uriArr.get(i));
            if(i!=uriArr.size()-1){
                sb.append(",");
            }
        }

        return ProductEntity.builder()
                .images(sb.toString())
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

        ArrayList<String> uriStr = new ArrayList<>(Arrays.asList(productEntity.getImages().split(",")));

        return ProductResponseDto.builder()
                .id(productEntity.getId())
                .createdAt(productEntity.getCreatedAt())
                .lastModifiedAt(productEntity.getLastModifiedAt())
                .images(uriStr)
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
