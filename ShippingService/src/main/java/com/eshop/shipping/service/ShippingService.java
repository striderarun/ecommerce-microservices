package com.eshop.shipping.service;

import com.eshop.shipping.domain.Shipping;

/**
 * Created by arun_subramonian on 12/19/16.
 */
public interface ShippingService {

    void createShippingRequest(Long orderId);

    void acknowledgeDelivery(Long shippingId);
}
