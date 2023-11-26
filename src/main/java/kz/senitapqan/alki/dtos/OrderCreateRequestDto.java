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
    private String address;
    private Long qid;
    private String size;
    private String color;
    private Long userId;
}
