package ericauction.ericaution.interfaces.rest.auction;

import ericauction.ericaution.domain.persistence.auction.ProductEntity;
import ericauction.ericaution.domain.request.auction.ProductSaveRequestDto;
import ericauction.ericaution.domain.response.auction.ProductResponseDto;
import ericauction.ericaution.interfaces.mapper.auction.ProductMapper;
import ericauction.ericaution.service.Auction.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuctionController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping("/product/")
    public ProductResponseDto saveProduct(@RequestBody ProductSaveRequestDto productSaveRequestDto){

        ProductEntity productEntity = productMapper.productSaveRequestToProductEntity(productSaveRequestDto);
        ProductEntity savedEntity = productService.save(productEntity);
        ProductResponseDto productResponseDto = productMapper.productEntityToProductResponseDto(savedEntity);

        return productResponseDto;
    }

    @GetMapping("/product/{id}")
    public ProductResponseDto findProductByID(@PathVariable Long id){

        ProductEntity productEntity = productService.findProductById(id);
        ProductResponseDto productResponseDto = productMapper.productEntityToProductResponseDto(productEntity);

        return productResponseDto;
    }

}
