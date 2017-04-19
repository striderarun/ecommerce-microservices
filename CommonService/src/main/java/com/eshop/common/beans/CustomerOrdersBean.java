package com.eshop.common.beans;

import com.eshop.common.enums.OrderStatus;

import java.io.Serializable;

/**
 * Created by arun_subramonian on 12/24/16.
 */
public class CustomerOrdersBean implements Serializable {

    private Long id;
    private Long customerId;
    private Long orderId;
    private OrderStatus orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
