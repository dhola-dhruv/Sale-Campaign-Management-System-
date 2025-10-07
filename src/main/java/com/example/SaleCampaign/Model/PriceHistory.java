package com.example.SaleCampaign.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "priceHistory")
public class PriceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductList productList;

    private double oldPrice;
    private double newPrice;
    private LocalDate date;
    private String reason;
    private double camDiscount;

}
