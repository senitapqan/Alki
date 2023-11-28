package kz.senitapqan.alki.service.impl;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductResponseDto;
import kz.senitapqan.alki.mapper.ProductMapper;
import kz.senitapqan.alki.models.Category;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.CategoryRepository;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import kz.senitapqan.alki.repository.ProductRepository;
import kz.senitapqan.alki.service.ProductDetailsService;
import kz.senitapqan.alki.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductDetailsRepository productDetailsRepository;

    @Override
    public Long create(ProductCreateRequestDto productCreateRequestDto) {
        Product product = productMapper.toEntity(productCreateRequestDto);
        productRepository.save(product);
        return product.getId();
    }
    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        Category category = product.getCategory();
        for (ProductDetails productDetails : product.getDetails()) {
            productDetailsRepository.deleteById(productDetails.getId());
        }
        category.getProducts().remove(product);
        productRepository.deleteById(id);
    }
    @Override
    public void updatePrice(Long id, int newPrice) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException());
        product.setPrice(newPrice);
        productRepository.save(product);
    }

    @Override
    public Long getIdByNameAndCategory(String name, String category) {
        Product product = productRepository.getProductsByNameAndCategory(name, category);
        if (product == null) throw new RuntimeException("There is no such product");
        return product.getId();
    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for (Product product : products) {
            productResponseDtoList.add(productMapper.toDto(product));
        }
        return productResponseDtoList;
    }


}
