package kz.senitapqan.alki.service;

import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.dtos.ProductDetailsDto;
import kz.senitapqan.alki.models.ProductDetails;

import java.util.List;

public interface ProductService {
    public List<ProductDetailsDto> getProductDetails(Long id);
    public List<ProductDetailsDto> getProductDetails(Long id, String color);
    public List<ProductDetailsDto> getProductDetails(Long id, String color, String size);

}
