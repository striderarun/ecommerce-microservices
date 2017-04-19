package com.eshop.order.rest.impl;

import com.eshop.common.beans.OrderBean;
import com.eshop.order.domain.Order;
import com.eshop.order.rest.OrderRestService;
import com.eshop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by arun_subramonian on 12/19/16.
 */
@RestController
@RequestMapping(value = "/services/order")
public class OrderRestServiceImpl implements OrderRestService {

    @Autowired
    private OrderService orderService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public OrderBean createOrder(@RequestBody OrderBean orderBean) {
        return orderService.createOrder(orderBean);
    }
}
