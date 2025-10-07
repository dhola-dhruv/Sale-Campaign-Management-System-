package com.example.SaleCampaign.Repository;

import com.example.SaleCampaign.Model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {
}
