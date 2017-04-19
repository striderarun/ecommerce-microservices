package com.eshop.order.domain;

import javax.persistence.*;

@Entity
@Table(name="ORDER_DETAILS")
@SequenceGenerator(name = "ORDER_DETAILS_SEQ", sequenceName = "ORDER_DETAILS_SEQ", allocationSize = 1)
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_DETAILS_SEQ")
    private Long id;

    private Long productId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
