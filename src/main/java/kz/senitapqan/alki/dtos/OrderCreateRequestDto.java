package kz.senitapqan.alki.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequestDto {
    private Long id;
    private String address;
    private Long productId;
    private String size;
    private String color;
    private Long userId;
    private String phone;
}
