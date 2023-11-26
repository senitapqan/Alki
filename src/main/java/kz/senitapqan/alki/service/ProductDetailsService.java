package kz.senitapqan.alki.service;


import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.dtos.ProductDetailsDto;

import java.util.List;

public interface ProductDetailsService {

    public ProductDetailUpdateResponse bookingProduct(Long id, String color, String size);

    public List<ProductDetailsDto> getProductDetails(Long id);
    public List<ProductDetailsDto> getProductDetails(Long id, String color);
    public List<ProductDetailsDto> getProductDetails(Long id, String color, String size);
}
