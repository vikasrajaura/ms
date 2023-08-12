package com.product;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product {

    @Id
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_category")
    private String productCategory;
    @Column(name = "price")
    private Integer price;

}
