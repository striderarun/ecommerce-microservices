package com.eshop.user.repository;
import com.eshop.common.enums.OrderStatus;
import com.eshop.user.domain.CustomerOrders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by arun_subramonian on 12/18/16.
 */
public interface CustomerOrderRepository extends JpaRepository<CustomerOrders, Long> {
    
    List<CustomerOrders> findByCustomerId(Long customerId);

    CustomerOrders findByCustomerIdAndOrderId(Long customerId, Long orderId);

    CustomerOrders findByOrderId(Long orderId);

    List<CustomerOrders> findByOrderStatus(OrderStatus orderStatus);

}
