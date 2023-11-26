package kz.senitapqan.alki.service.impl;

import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.dtos.ProductDetailsDto;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import kz.senitapqan.alki.repository.ProductRepository;
import kz.senitapqan.alki.service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {
    private ProductDetailsRepository productDetailsRepository;
    private final ProductRepository productRepository;
    @Override
    public ProductDetailUpdateResponse bookingProduct(Long id, String color, String size) {
        ProductDetails productDetails = productDetailsRepository.findProductDetailsBySizeAndColor(size, color, id);
        if (productDetails.getFree() <= 0) {
            return new ProductDetailUpdateResponse("sorry there is no any items of this product");
        }
        productDetails.setFree(productDetails.getFree() - 1);
        productDetails.setReserved(productDetails.getReserved() + 1);
        productDetailsRepository.save(productDetails);
        return new ProductDetailUpdateResponse("Changed successfully!");
    }
    @Override
    public List<ProductDetailsDto> getProductDetails(Long id) {
        Product product = productRepository.getProductByQid(id);
        List<ProductDetails> productList = product.getDetails();
        List<ProductDetailsDto> productDetailsDtoList = new ArrayList<>();
        for (ProductDetails product1 : productList) {
            ProductDetailsDto productDetailsDto = new ProductDetailsDto();
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
    public List<ProductDetailsDto> getProductDetails(Long id, String color) {
        List<ProductDetailsDto> productDetailsList = getProductDetails(id);

        List<ProductDetailsDto> productDetailsListWithColor = new ArrayList<>();
        for (ProductDetailsDto productDetails : productDetailsList) {
            if (Objects.equals(productDetails.getColor(), color))
                productDetailsListWithColor.add(productDetails);
        }

        return productDetailsListWithColor;
    }

    @Override
    public List<ProductDetailsDto> getProductDetails(Long id, String color, String size) {
        List<ProductDetailsDto> productDetailsList = getProductDetails(id, color);

        List<ProductDetailsDto> productDetailsListWithSize = new ArrayList<>();
        for (ProductDetailsDto productDetails : productDetailsList) {
            if (Objects.equals(productDetails.getSize(), size))
                productDetailsListWithSize.add(productDetails);
        }

        return productDetailsListWithSize;
    }
}
