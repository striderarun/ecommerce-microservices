package com.eshop.gateway.client;

import com.eshop.common.beans.ProductBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by arun_subramonian on 12/24/16.
 */
@FeignClient("http://shippingService")
public interface ShippingClient {

    @RequestMapping(value = "/eshop/services/shipping/order/{id}", method = RequestMethod.POST)
    void createShipping(@PathVariable("id") Long id);

    @RequestMapping(value= "/eshop/services/shipping/{id}", method = RequestMethod.POST)
    public void acknowledgeDelivery(@PathVariable("id") Long id);
}
