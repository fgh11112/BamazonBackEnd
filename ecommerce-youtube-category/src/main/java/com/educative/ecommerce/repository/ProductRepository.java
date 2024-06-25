package com.educative.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educative.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
