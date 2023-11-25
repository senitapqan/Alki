package kz.senitapqan.alki.service;


import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;

public interface ProductDetailsService {

    public ProductDetailUpdateResponse bookingProduct(Long id, String color, String size);
}
