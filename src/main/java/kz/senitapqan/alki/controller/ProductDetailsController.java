package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.dtos.ProductDetailsDto;
import kz.senitapqan.alki.service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/getId")
    @ResponseBody
    public List<ProductDetailsDto> getProductDetails(@RequestParam("id") Long id) {
        List<ProductDetailsDto> productDetails = productDetailsService.getProductDetails(id);
        return productDetails;
    }
    @GetMapping("/getColor")
    @ResponseBody
    public List<ProductDetailsDto> getProductDetails(@RequestParam("id") Long id,
                                                     @RequestParam("color") String color) {
        return productDetailsService.getProductDetails(id, color);
    }
    @GetMapping("/getSize")
    @ResponseBody
    public List<ProductDetailsDto> getProductDetails(@RequestParam("id") Long id,
                                                     @RequestParam("color") String color,
                                                     @RequestParam("size") String size) {
        return productDetailsService.getProductDetails(id, color, size);
    }
}
