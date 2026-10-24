package com.nt.repository.prodrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.product.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
