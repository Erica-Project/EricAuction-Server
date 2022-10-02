package ericauction.ericaution.service.Auction;

import ericauction.ericaution.domain.persistence.auction.ProductEntity;
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

    @Transactional
    public ProductEntity save(ProductEntity productEntity){
        ProductEntity savedEntity = productRepository.save(productEntity);
        return savedEntity;
    }

    public ProductEntity findProductById(Long id){
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 객체는 존재하지 않습니다. id = "+id));
        return productEntity;
    }
}
