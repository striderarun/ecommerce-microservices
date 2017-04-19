package com.eshop.product.repository;

import com.eshop.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arun_subramonian on 12/18/16.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
