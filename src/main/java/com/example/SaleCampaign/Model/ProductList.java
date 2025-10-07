package com.example.SaleCampaign.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "productList")
public class ProductList {
    @Id
    private String pId;
    private String productTitle;
    private double maximumRetailPrice;
    private double currentPrice;
    private double discount;
    private int inventoryCount;

    @OneToMany(mappedBy = "productList")
    @JsonIgnore
    private List<ProductDiscount> productDiscounts1;

    @OneToMany(mappedBy = "productList")
    @JsonIgnore
    private List<PriceHistory> priceHistories;

}
