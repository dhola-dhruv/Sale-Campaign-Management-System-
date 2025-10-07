package com.example.SaleCampaign.Repository;

import com.example.SaleCampaign.Model.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList, String> {
}
