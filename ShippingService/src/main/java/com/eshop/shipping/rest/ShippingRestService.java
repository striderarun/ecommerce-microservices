package com.eshop.shipping.rest;

/**
 * Created by arun_subramonian on 12/19/16.
 */
public interface ShippingRestService {

    void createShipping(Long orderId);

    void acknowledgeDelivery(Long shippingId);
}
