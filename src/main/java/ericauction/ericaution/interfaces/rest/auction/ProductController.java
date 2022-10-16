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
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;


    @PostMapping("/product/")
    public ProductResponseDto saveProduct(@RequestBody ProductSaveRequestDto productSaveRequestDto){
        return productService.save(productSaveRequestDto);
    }

    @GetMapping("/product/{id}")
    public ProductResponseDto findProductByID(@PathVariable Long id){
        return productService.findProductById(id);
    }

}
