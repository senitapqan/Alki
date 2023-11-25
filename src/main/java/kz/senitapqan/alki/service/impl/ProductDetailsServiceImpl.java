package kz.senitapqan.alki.service.impl;

import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.repository.ProductDetailsRepository;
import kz.senitapqan.alki.service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductDetailsServiceImpl implements ProductDetailsService {
    private ProductDetailsRepository productDetailsRepository;
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
}
