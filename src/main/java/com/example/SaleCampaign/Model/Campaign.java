package com.example.SaleCampaign.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cId;
    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(mappedBy = "campaign", cascade = CascadeType.ALL)
    private List<ProductDiscount> productDiscounts2;

}
