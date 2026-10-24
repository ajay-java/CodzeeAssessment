package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.entity.offers.Offers;
import com.nt.entity.product.Product;

public interface IProductMgmtService {
   public String saveProductAndOffers(Product prod,Offers offrs);
   public Map<String, Object> showProductsAndOffers();
}
