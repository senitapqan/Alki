package kz.senitapqan.alki.service;


import kz.senitapqan.alki.dtos.ProductDetailsCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductDetailsResponseDto;

import java.util.List;

public interface ProductDetailsService {

    public void bookingProduct(Long id, String color, String size);

    public List<ProductDetailsResponseDto> getProductDetails(Long id);
    public List<ProductDetailsResponseDto> getProductDetails(Long id, String color);
    public List<ProductDetailsResponseDto> getProductDetails(Long id, String color, String size);

    public Long create(ProductDetailsCreateRequestDto productDetailsCreateRequestDto);

    public void addCount(Long id, int count);

    public List<ProductDetailsResponseDto> getAll();
    public List<ProductDetailsResponseDto> getAllByProductName(String name);
    public List<ProductDetailsResponseDto> getAllByProductId(Long id);
    public ProductDetailsResponseDto getById(Long id);

    public void deleteById(Long id);
}
