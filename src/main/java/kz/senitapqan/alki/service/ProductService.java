package kz.senitapqan.alki.service;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductResponseDto;

import java.util.List;

public interface ProductService {
    public Long create(ProductCreateRequestDto productCreateRequestDto);
    public void delete(Long id);
    public void updatePrice(Long id, int newPrice);
    public Long getIdByNameAndCategory(String name, String category);
    public List<ProductResponseDto> getAllProducts();
}
