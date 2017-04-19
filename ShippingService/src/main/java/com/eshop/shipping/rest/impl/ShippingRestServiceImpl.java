package com.eshop.shipping.rest.impl;

import com.eshop.shipping.rest.ShippingRestService;
import com.eshop.shipping.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arun_subramonian on 12/19/16.
 */
@RestController
@RequestMapping(value = "/services/shipping")
public class ShippingRestServiceImpl implements ShippingRestService {

    @Autowired
    private ShippingService shippingService;

    @Override
    @RequestMapping(value= "/order/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createShipping(@PathVariable Long id) {
        shippingService.createShippingRequest(id);
    }

    @Override
    @RequestMapping(value= "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void acknowledgeDelivery(@PathVariable Long shippingId) {
        shippingService.acknowledgeDelivery(shippingId);
    }
}
