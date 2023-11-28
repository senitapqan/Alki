package kz.senitapqan.alki.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "t_orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "data")
    private String date;
    @Column(name = "user_id")
    private Long user;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
    @Column(name = "price")
    private int price;
    @Column(name = "phone")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    private ProductDetails productDetails;

}
