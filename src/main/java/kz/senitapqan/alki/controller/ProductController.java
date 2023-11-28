package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductResponseDto;
import kz.senitapqan.alki.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
        Long id = productService.create(productCreateRequestDto);
        return ResponseEntity.ok(String.format("Added new product with id = %d", id));
    }
    //delete by id;
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
    @PutMapping("/updatePrice")
    public ResponseEntity<String> updatePrice(@RequestParam("id") Long id, @RequestParam("price") int price) {
        productService.updatePrice(id, price);
        return ResponseEntity.ok( "Success");
    }

    @GetMapping("/get")
    public ResponseEntity<Long> getProduct(@RequestParam("name") String name, @RequestParam("category") String category) {
        Long id = productService.getIdByNameAndCategory(name, category);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
}
