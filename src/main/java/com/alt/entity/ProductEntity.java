package com.alt.entity;

import com.alt.util.ProductType;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;


@Data
@Entity
@Table(name="product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String brand;
    private int warranty;
    private int prize;
    private int quantity;
    private LocalDate mfd;
    @Enumerated(EnumType.STRING)
    private ProductType type;
}
