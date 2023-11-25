package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductDetailsController {
    private final ProductDetailsService productDetailsService;
    @PostMapping("/bookingProduct")
    public ProductDetailUpdateResponse bookingProduct(@RequestParam("id") Long id,
                                                      @RequestParam("color") String color,
                                                      @RequestParam("size") String size) {
        return productDetailsService.bookingProduct(id, color, size);
    }
}
