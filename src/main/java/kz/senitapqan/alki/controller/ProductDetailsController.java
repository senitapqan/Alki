package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.ProductDetailsCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductDetailsResponseDto;
import kz.senitapqan.alki.service.ProductDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product/details")
public class ProductDetailsController {
    private final ProductDetailsService productDetailsService;
    @PostMapping("/bookingProduct")
    public ResponseEntity<String> bookingProduct(@RequestParam("id") Long id,
                                                      @RequestParam("color") String color,
                                                      @RequestParam("size") String size) {
        productDetailsService.bookingProduct(id, color, size);
        return ResponseEntity.ok("done :)");
    }
    @GetMapping("/getId")
    @ResponseBody
    public ResponseEntity<List<ProductDetailsResponseDto>> getProductDetails(@RequestParam("id") Long id) {
        List<ProductDetailsResponseDto> productDetails = productDetailsService.getProductDetails(id);
        return ResponseEntity.ok(productDetails);
    }
    @GetMapping("/getColor")
    @ResponseBody
    public ResponseEntity<List<ProductDetailsResponseDto>> getProductDetails(@RequestParam("id") Long id,
                                                             @RequestParam("color") String color) {
        return ResponseEntity.ok(productDetailsService.getProductDetails(id, color));
    }
    @GetMapping("/getSize")
    @ResponseBody
    public List<ProductDetailsResponseDto> getProductDetails(@RequestParam("id") Long id,
                                                             @RequestParam("color") String color,
                                                             @RequestParam("size") String size) {
        return productDetailsService.getProductDetails(id, color, size);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDetailsCreateRequestDto productDetailsCreateRequestDto) {
        Long id = productDetailsService.create(productDetailsCreateRequestDto);
        return ResponseEntity.ok(String.format("Created item of product with id = %d", id));
    }

    @PutMapping("/update/count")
    public ResponseEntity<String> updateCount(@RequestParam Long id, @RequestParam int count) {
        productDetailsService.addCount(id, count);
        return ResponseEntity.ok(String.format("added %d items", count));
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ProductDetailsResponseDto>> getAll() {
        return ResponseEntity.ok(productDetailsService.getAll());
    }

    @GetMapping("/get-by-name")
    public ResponseEntity<List<ProductDetailsResponseDto>> getAllByProductName(@RequestParam("name") String name) {
        return ResponseEntity.ok(productDetailsService.getAllByProductName(name));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<List<ProductDetailsResponseDto>> getAllByProductId(@PathVariable Long id) {
        return ResponseEntity.ok(productDetailsService.getAllByProductId(id));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProductDetailsResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productDetailsService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        productDetailsService.deleteById(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
