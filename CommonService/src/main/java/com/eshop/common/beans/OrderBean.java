package com.eshop.common.beans;

import com.eshop.common.enums.OrderStatus;

import java.util.Set;

/**
 * Created by arun_subramonian on 12/23/16.
 */
public class OrderBean {

    private Long id;
    private Long customerId;
    private OrderStatus status;
    private Double cost;
    private Set<Long> productIds;

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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Set<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Long> productIds) {
        this.productIds = productIds;
    }
}
