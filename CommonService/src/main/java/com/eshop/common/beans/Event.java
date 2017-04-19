package com.eshop.common.beans;

import java.io.Serializable;

/**
 * Created by arun_subramonian on 12/21/16.
 */
public class Event implements Serializable {

    private Long orderId;
    private Long customerId;
    private Long productId;
    private Long shippingId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }
}
