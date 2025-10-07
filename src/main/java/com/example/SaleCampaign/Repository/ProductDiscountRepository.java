package com.example.SaleCampaign.Repository;

import com.example.SaleCampaign.Model.ProductDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Integer> {
}
