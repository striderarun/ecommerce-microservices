package com.eshop.common.beans;

import com.eshop.common.enums.ShippingStatus;

/**
 * Created by arun_subramonian on 12/23/16.
 */
public class ShippingBean {

    private Long id;
    private Long orderId;
    private ShippingStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }
}
