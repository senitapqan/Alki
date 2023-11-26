package kz.senitapqan.alki.service;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.dtos.ProductDetailsDto;
import kz.senitapqan.alki.models.ProductDetails;

import java.util.List;

public interface ProductService {
    public Long save(ProductCreateRequestDto productCreateRequestDto);
    public boolean delete(Long id);
    public boolean updatePrice(Long id, int newPrice);

}
