package kz.senitapqan.alki.mapped;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final ProductRepository productRepository;
    public Product toEntity(ProductCreateRequestDto productCreateRequestDto) {
        Product productFromDB = productRepository.getProductByQid(productCreateRequestDto.getQid());
        if (productFromDB != null) {
            throw new RuntimeException("You can't add two products with same qid");
        }
        Product product = new Product();
        product.setQid(productCreateRequestDto.getQid());
        product.setName(productCreateRequestDto.getName());
        product.setPrice(productCreateRequestDto.getPrice());
        return product;
    }

}
