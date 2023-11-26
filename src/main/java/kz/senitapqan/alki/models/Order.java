package kz.senitapqan.alki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id")
    private Long user;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
    @Column(name = "price")
    private int price;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductDetails productDetails;


}
