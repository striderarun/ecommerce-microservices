package com.eshop.order.repository;

import com.eshop.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by arun_subramonian on 12/18/16.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
