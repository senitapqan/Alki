package kz.senitapqan.alki.controller;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
        Long id = productService.save(productCreateRequestDto);
        return ResponseEntity.ok(String.format("Added new product with id = %d", id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
    @PutMapping("/updatePrice")
    public ResponseEntity<String> updatePrice(@RequestParam("id") Long id, @RequestParam("price") int price) {
        boolean ok = productService.updatePrice(id, price);
        if (!ok)
               throw new RuntimeException("Something got wrong while updating");
        return ResponseEntity.ok( "Success");
    }
}
