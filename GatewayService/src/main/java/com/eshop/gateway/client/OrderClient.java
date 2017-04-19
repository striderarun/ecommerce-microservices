package com.eshop.gateway.client;

import com.eshop.common.beans.OrderBean;
import com.eshop.common.beans.ProductBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

/**
 * Created by arun_subramonian on 12/24/16.
 */
@FeignClient("http://orderService")
public interface OrderClient {

    @RequestMapping(value = "/eshop/services/order", method = RequestMethod.POST)
    public OrderBean createOrder(@RequestBody OrderBean orderBean);

}
