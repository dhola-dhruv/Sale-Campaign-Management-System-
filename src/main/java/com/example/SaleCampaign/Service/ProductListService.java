package com.example.SaleCampaign.Service;

import com.example.SaleCampaign.Model.ProductList;
import com.example.SaleCampaign.Repository.ProductListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class ProductListService {

    @Autowired
    ProductListRepository productListRepository;

    public void saveProduct(ProductList productList){
        productList.setCurrentPrice(productList.getMaximumRetailPrice() - (
                productList.getMaximumRetailPrice() * (productList.getDiscount() / 100)));
        productListRepository.save(productList);
    }

    public void saveAllProducts(List<ProductList> productLists) {
        for (ProductList productList: productLists){
            productList.setCurrentPrice(productList.getMaximumRetailPrice() - (
                    productList.getMaximumRetailPrice() * (productList.getDiscount() / 100)));
        }
        productListRepository.saveAll(productLists);
    }

    public Page<ProductList> getProducts(Pageable pageable) {
        return productListRepository.findAll(pageable);
    }
}
