package com.eshop.shipping.repository;

import com.eshop.shipping.domain.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arun_subramonian on 12/18/16.
 */
public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
