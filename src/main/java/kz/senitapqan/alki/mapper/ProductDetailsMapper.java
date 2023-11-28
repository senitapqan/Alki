package kz.senitapqan.alki.mapper;

import kz.senitapqan.alki.dtos.ProductDetailsCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductDetailsResponseDto;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import kz.senitapqan.alki.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class ProductDetailsMapper {
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductRepository productRepository;

    public ProductDetails toEntity(ProductDetailsCreateRequestDto productDetailsCreateRequestDto) {
        Product product = productRepository.findById(productDetailsCreateRequestDto.getProductId()).orElseThrow(RuntimeException::new);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setFree(productDetailsCreateRequestDto.getFree());
        productDetails.setReserved(0);
        productDetails.setProduct(product);
        productDetails.setColor(productDetailsCreateRequestDto.getColor());
        productDetails.setSize(productDetailsCreateRequestDto.getSize());
        return productDetails;
    }
    public ProductDetailsResponseDto toDto(ProductDetails productDetails) {
        return new ProductDetailsResponseDto(productDetails.getId(), productDetails.getSize(), productDetails.getColor(),
                productDetails.getFree(), productDetails.getReserved(), productDetails.getProduct().getName());
    }

    public List<ProductDetailsResponseDto> toDto(List<ProductDetails> productDetailsList) {
        List<ProductDetailsResponseDto> productDetailsResponseDtoList = new ArrayList<>();
        for (ProductDetails productDetails : productDetailsList)
            productDetailsResponseDtoList.add(toDto(productDetails));
        return productDetailsResponseDtoList;
    }
}
