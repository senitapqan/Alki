package kz.senitapqan.alki.service.impl;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.dtos.ProductDetailsDto;
import kz.senitapqan.alki.mapped.ProductMapper;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import kz.senitapqan.alki.repository.ProductRepository;
import kz.senitapqan.alki.service.ProductDetailsService;
import kz.senitapqan.alki.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductDetailsService productDetailsService;

    @Override
    public Long save(ProductCreateRequestDto productCreateRequestDto) {
        Product product = productMapper.toEntity(productCreateRequestDto);
        productRepository.save(product);
        return productRepository.getProductByQid(product.getQid()).getId();
    }

    @Override
    public boolean delete(Long id) {
        return true;
    }

    @Override
    public boolean updatePrice(Long id, int newPrice) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
        product.setPrice(newPrice);
        productRepository.save(product);
        return true;
    }


}
