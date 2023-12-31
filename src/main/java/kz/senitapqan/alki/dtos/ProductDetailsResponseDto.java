package kz.senitapqan.alki.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDetailsResponseDto {
    private Long id;
    private String size;
    private String color;
    private int free;
    private int reserved;
    private String name;
}
