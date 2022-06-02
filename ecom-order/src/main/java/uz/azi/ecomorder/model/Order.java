package uz.azi.ecomorder.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.azi.ecomorder.enums.OrderStatus;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OrderStatus status;

    @Column(name = "user_id")
    private Long userId;

    private int quantity;

    private boolean deleted;

    @OneToMany(mappedBy = "order")
    private List<SoldProduct> products;




}
