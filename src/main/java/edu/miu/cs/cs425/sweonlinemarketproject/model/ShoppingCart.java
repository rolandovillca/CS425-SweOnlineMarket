package edu.miu.cs.cs425.sweonlinemarketproject.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShoppingCart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne(mappedBy = "shoppingCart")
    private User buyer;

    @OneToMany
    @JoinColumn(name= "carts_products")
    private List<Product> products;

}
