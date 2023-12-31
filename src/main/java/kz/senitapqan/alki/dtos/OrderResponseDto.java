package kz.senitapqan.alki.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {
    private Long id;
    private String name;
    private String color;
    private String size;
    private String address;
    private String status;
    private String date;
}
