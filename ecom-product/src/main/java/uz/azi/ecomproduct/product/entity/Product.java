package uz.azi.ecomproduct.product.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@RequiredArgsConstructor
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false, unique = true)
    private UUID code;
    private Double price = 0.0;
    private Integer count =0;
    private boolean deleted;

    private Long userId;

}
