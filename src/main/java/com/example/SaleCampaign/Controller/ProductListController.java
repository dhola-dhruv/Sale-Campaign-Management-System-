package com.example.SaleCampaign.Controller;

import com.example.SaleCampaign.Model.ProductList;
import com.example.SaleCampaign.Service.ProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("productLists")
public class ProductListController {

    @Autowired
    ProductListService productListService;

    @PostMapping("saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody ProductList productList){
        try {
            productListService.saveProduct(productList);
            return ResponseEntity.ok("Product saved successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error saving Product: " + e.getMessage());
        }
    }

    @PostMapping("saveAllProducts")
    public ResponseEntity<?> saveAllProducts(@RequestBody List<ProductList> productLists){
        try {
            productListService.saveAllProducts(productLists);
            return ResponseEntity.ok("ProductList saved successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error saving ProductList: " + e.getMessage());
        }
    }

    @GetMapping("products")
    public Page<ProductList> getProducts(@RequestParam int page, @RequestParam(name = "pageSize", defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        return productListService.getProducts(pageable);
    }
}
