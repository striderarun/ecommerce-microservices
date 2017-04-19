package com.eshop.shipping.domain;


import com.eshop.common.enums.ShippingStatus;

import javax.persistence.*;

@Entity
@Table(name="SHIPPING")
@SequenceGenerator(name = "SHIPPING_SEQ", sequenceName = "SHIPPING_SEQ", allocationSize = 1)
public class Shipping {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SHIPPING_SEQ")
    private Long id;

    private Long orderId;

    @Enumerated(EnumType.STRING)
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
