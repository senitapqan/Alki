package kz.senitapqan.alki.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponseDto {
    private Long productId;
    private String name;
    private String categoryName;
    private int price;

}
