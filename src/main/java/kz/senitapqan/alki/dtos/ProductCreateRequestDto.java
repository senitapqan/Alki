package kz.senitapqan.alki.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCreateRequestDto {
    private Long qid;
    private int price;
    private String name;

}
