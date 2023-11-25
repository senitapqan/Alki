package kz.senitapqan.alki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "t_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "query_id")
    private Long qid; //id

    @Column(name = "price")
    private int price; //tenge

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<ProductDetails> details;
}
