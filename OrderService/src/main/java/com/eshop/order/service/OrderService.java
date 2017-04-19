package com.eshop.order.service;

import com.eshop.common.beans.OrderBean;
import com.eshop.common.enums.OrderStatus;
import com.eshop.order.domain.Order;

/**
 * Created by arun_subramonian on 12/19/16.
 */
public interface OrderService {

    OrderBean findOrder(Long orderId);

    OrderBean createOrder(OrderBean orderBean);

    void updateOrderStatus(Long orderId, OrderStatus orderStatus);
}
