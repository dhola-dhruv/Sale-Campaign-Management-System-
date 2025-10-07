package com.example.SaleCampaign.Controller;

import com.example.SaleCampaign.Model.Campaign;
import com.example.SaleCampaign.Service.CampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("Campaigns")
public class CampaignController {

    @Autowired
    CampaignService campaignService;

    @PostMapping("saveCampaign")
    public ResponseEntity<?> saveCampaign(@RequestBody Campaign campaign) {
        try {
            campaignService.saveCampaign(campaign);
            return ResponseEntity.ok("Campaign saved successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error saving campaign: " + e.getMessage());
        }
    }

}