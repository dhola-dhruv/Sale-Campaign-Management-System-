package com.example.SaleCampaign.Service;

import com.example.SaleCampaign.Model.Campaign;
import com.example.SaleCampaign.Model.ProductDiscount;
import com.example.SaleCampaign.Model.ProductList;
import com.example.SaleCampaign.Repository.CampaignRepository;
import com.example.SaleCampaign.Repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProductListRepository productListRepository;

    public void saveCampaign(Campaign campaign){
        for (ProductDiscount pd: campaign.getProductDiscounts2()){
            pd.setCampaign(campaign);

            String pId = pd.getProductList().getpId();
            ProductList product = productListRepository.findById(pId).orElseThrow(() ->
                    new RuntimeException("Product with ID " + pId + " not found"));
            pd.setProductList(product);
        }
        campaignRepository.save(campaign);
    }

}
