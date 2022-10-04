package ericauction.ericaution.service.Auction;

import ericauction.ericaution.domain.persistence.auction.ProductEntity;
import ericauction.ericaution.domain.request.auction.ProductSaveRequestDto;
import ericauction.ericaution.domain.response.auction.ProductResponseDto;
import ericauction.ericaution.interfaces.mapper.auction.ProductMapper;
import ericauction.ericaution.interfaces.repository.auction.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductResponseDto save(ProductSaveRequestDto productSaveRequestDto){
        ProductEntity productEntity = productMapper.productSaveRequestToProductEntity(productSaveRequestDto);
        ProductEntity savedEntity = productRepository.save(productEntity);
        ProductResponseDto productResponseDto = productMapper.productEntityToProductResponseDto(savedEntity);

        return productResponseDto;
    }

    public ProductResponseDto findProductById(Long id){
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 객체는 존재하지 않습니다. id = "+id));
        ProductResponseDto productResponseDto = productMapper.productEntityToProductResponseDto(productEntity);
        return productResponseDto;
    }
}
