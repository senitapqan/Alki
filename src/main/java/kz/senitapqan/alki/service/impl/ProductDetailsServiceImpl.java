package kz.senitapqan.alki.service.impl;

import kz.senitapqan.alki.dtos.ProductDetailsCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductDetailsResponseDto;
import kz.senitapqan.alki.mapper.ProductDetailsMapper;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import kz.senitapqan.alki.repository.ProductRepository;
import kz.senitapqan.alki.service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {
    private ProductDetailsRepository productDetailsRepository;
    private final ProductRepository productRepository;
    private final ProductDetailsMapper productDetailsMapper;

    @Override
    public void bookingProduct(Long id, String color, String size) {
        ProductDetails productDetails = productDetailsRepository.findProductDetailsBySizeAndColor(size, color, id);
        if (productDetails.getFree() <= 0) {
            throw new RuntimeException("there is no any product of this type");
        }
        productDetails.setFree(productDetails.getFree() - 1);
        productDetails.setReserved(productDetails.getReserved() + 1);
        productDetailsRepository.save(productDetails);
    }
    @Override
    public List<ProductDetailsResponseDto> getProductDetails(Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        List<ProductDetails> productList = product.getDetails();
        List<ProductDetailsResponseDto> productDetailsDtoList = new ArrayList<>();
        for (ProductDetails product1 : productList) {
            ProductDetailsResponseDto productDetailsDto = new ProductDetailsResponseDto();
            productDetailsDto.setId(product1.getId());
            productDetailsDto.setFree(product1.getFree());
            productDetailsDto.setReserved(product1.getReserved());
            productDetailsDto.setSize(product1.getSize());
            productDetailsDto.setColor(product1.getColor());
            productDetailsDtoList.add(productDetailsDto);
        }
        return productDetailsDtoList;
    }

    @Override
    public List<ProductDetailsResponseDto> getProductDetails(Long id, String color) {
        List<ProductDetailsResponseDto> productDetailsList = getProductDetails(id);

        List<ProductDetailsResponseDto> productDetailsListWithColor = new ArrayList<>();
        for (ProductDetailsResponseDto productDetails : productDetailsList) {
            if (Objects.equals(productDetails.getColor(), color))
                productDetailsListWithColor.add(productDetails);
        }

        return productDetailsListWithColor;
    }

    @Override
    public List<ProductDetailsResponseDto> getProductDetails(Long id, String color, String size) {
        List<ProductDetailsResponseDto> productDetailsList = getProductDetails(id, color);

        List<ProductDetailsResponseDto> productDetailsListWithSize = new ArrayList<>();
        for (ProductDetailsResponseDto productDetails : productDetailsList) {
            if (Objects.equals(productDetails.getSize(), size))
                productDetailsListWithSize.add(productDetails);
        }

        return productDetailsListWithSize;
    }

    @Override
    public Long create(ProductDetailsCreateRequestDto productDetailsCreateRequestDto) {
        ProductDetails productDetails = productDetailsMapper.toEntity(productDetailsCreateRequestDto);
        productDetailsRepository.save(productDetails);
        return productDetails.getId();
    }

    @Override
    public void addCount(Long id, int count) {
        ProductDetails productDetails = productDetailsRepository.findById(id).orElseThrow(RuntimeException::new);
        productDetails.setFree(productDetails.getFree() + count);
        productDetailsRepository.save(productDetails);
    }

    @Override
    public List<ProductDetailsResponseDto> getAll() {
        return productDetailsMapper.toDto(
                productDetailsRepository.findAll());
    }

    @Override
    public List<ProductDetailsResponseDto> getAllByProductName(String name) {
        return productDetailsMapper.toDto(
                productDetailsRepository.getProductDetailsByProductName(name));
    }

    @Override
    public List<ProductDetailsResponseDto> getAllByProductId(Long id) {
        return productDetailsMapper.toDto(
                productDetailsRepository.getProductDetailsByProductId(id));
    }

    @Override
    public ProductDetailsResponseDto getById(Long id) {
        return productDetailsMapper.toDto(
                productDetailsRepository.findById(id).orElseThrow(RuntimeException::new)
        );
    }

    @Override
    public void deleteById(Long id) {
        ProductDetails productDetails = productDetailsRepository.findById(id).orElseThrow(RuntimeException::new);
        productDetails.getProduct().getDetails().remove(productDetails);
        productDetailsRepository.deleteById(id);
    }




}
