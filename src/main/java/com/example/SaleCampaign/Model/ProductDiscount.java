package com.example.SaleCampaign.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productDiscount")
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pdId;
    private double campaignDiscount;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductList productList;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

}
