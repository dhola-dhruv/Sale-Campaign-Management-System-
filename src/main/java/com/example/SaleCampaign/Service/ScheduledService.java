package com.example.SaleCampaign.Service;

import com.example.SaleCampaign.Model.Campaign;
import com.example.SaleCampaign.Model.PriceHistory;
import com.example.SaleCampaign.Model.ProductDiscount;
import com.example.SaleCampaign.Model.ProductList;
import com.example.SaleCampaign.Repository.CampaignRepository;
import com.example.SaleCampaign.Repository.PriceHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduledService {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    PriceHistoryRepository priceHistoryRepository;

    @Scheduled(cron = "00 39 12 * * ?")
    @Transactional
    public void campaignStart(){
        List<Campaign> campaigns = campaignRepository.findAll();

        LocalDate today = LocalDate.of(2025, 9, 26);

        for (Campaign campaign: campaigns){
            if (campaign.getStartDate().isEqual(today)){
                List<ProductDiscount> productDiscounts = campaign.getProductDiscounts2();

                for (ProductDiscount productDiscount: productDiscounts){
                    ProductList productList = productDiscount.getProductList();

                    double oldPrice = productList.getCurrentPrice();
                    double newPrice = productList.getCurrentPrice() - (
                            productList.getCurrentPrice() * (productDiscount.getCampaignDiscount() / 100));

                    productList.setCurrentPrice(newPrice);

                    PriceHistory history = new PriceHistory();
                    history.setProductList(productList);
                    history.setOldPrice(oldPrice);
                    history.setNewPrice(newPrice);
                    history.setDate(today);
                    history.setReason("Campaign Started: " + campaign.getCampaignName());
                    history.setCamDiscount(productDiscount.getCampaignDiscount());

                    priceHistoryRepository.save(history);
                }
            }
        }
    }

    @Scheduled(cron = "00 40 12 * * ?")
    @Transactional
    public void campaignEnd(){
        List<Campaign> campaigns = campaignRepository.findAll();

        LocalDate today = LocalDate.of(2025, 9, 27);

        for (Campaign campaign: campaigns){
            if (campaign.getEndDate().isEqual(today)){
                List<ProductDiscount> productDiscounts = campaign.getProductDiscounts2();

                for (ProductDiscount productDiscount: productDiscounts){
                    ProductList productList = productDiscount.getProductList();

                    double oldPrice = productList.getCurrentPrice();
                    double newPrice = productList.getCurrentPrice() / (
                            (100 - productDiscount.getCampaignDiscount())/ 100);

                    productList.setCurrentPrice(newPrice);

                    PriceHistory history = new PriceHistory();
                    history.setProductList(productList);
                    history.setOldPrice(oldPrice);
                    history.setNewPrice(newPrice);
                    history.setDate(today);
                    history.setReason("Campaign Ended: " + campaign.getCampaignName());
                    history.setCamDiscount(productDiscount.getCampaignDiscount());

                    priceHistoryRepository.save(history);
                }
            }
        }
    }
}
