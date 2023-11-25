package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.ProductDetailUpdateResponse;
import kz.senitapqan.alki.dtos.ProductDetailsDto;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.models.ProductDetails;
import kz.senitapqan.alki.service.ProductService;
import kz.senitapqan.alki.service.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/getId")
    @ResponseBody
    public List<ProductDetailsDto> getProductDetails(@RequestParam("id") Long id) {
        List<ProductDetailsDto> productDetails = productService.getProductDetails(id);
        return productDetails;
    }
    @GetMapping("/getColor")
    @ResponseBody
    public List<ProductDetailsDto> getProductDetails(@RequestParam("id") Long id,
                                                  @RequestParam("color") String color) {
        return productService.getProductDetails(id, color);
    }
    @GetMapping("/getSize")
    @ResponseBody
    public List<ProductDetailsDto> getProductDetails(@RequestParam("id") Long id,
                                                  @RequestParam("color") String color,
                                                  @RequestParam("size") String size) {
        return productService.getProductDetails(id, color, size);
    }

}
