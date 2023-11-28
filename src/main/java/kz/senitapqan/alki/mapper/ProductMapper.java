package kz.senitapqan.alki.mapper;

import kz.senitapqan.alki.dtos.ProductCreateRequestDto;
import kz.senitapqan.alki.dtos.ProductResponseDto;
import kz.senitapqan.alki.models.Category;
import kz.senitapqan.alki.models.Product;
import kz.senitapqan.alki.repository.CategoryRepository;
import kz.senitapqan.alki.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductMapper {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public Product toEntity(ProductCreateRequestDto productCreateRequestDto) {;
        Category category = categoryRepository.getCategoryByName(productCreateRequestDto.getCategory());
        if (category == null) {
            throw new RuntimeException("There is no such category");
        }

        Product productFromDB = productRepository.getProductsByNameAndCategory(productCreateRequestDto.getName(), category.getName());
        if (productFromDB != null) {
            throw new RuntimeException("You already have product with such name & category");
        }

        Product product = new Product();
        product.setName(productCreateRequestDto.getName());
        product.setCategory(category);
        product.setPrice(productCreateRequestDto.getPrice());
        return product;
    }

    public ProductResponseDto toDto(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto(product.getId(), product.getName(),
                product.getCategory().getName(), product.getPrice());
        return productResponseDto;
    }

}
