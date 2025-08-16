package com.alt.dto;


import com.alt.util.ProductType;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ProductDTO
{
    private long id;
    private String name;
    private String brand;
    private int warranty;
    private int prize;
    private int quantity;
    private LocalDate mfd;
    private ProductType type;
}
