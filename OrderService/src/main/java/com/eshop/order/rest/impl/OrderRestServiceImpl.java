package com.eshop.order.rest.impl;

import com.eshop.common.beans.OrderBean;
import com.eshop.order.domain.Order;
import com.eshop.order.rest.OrderRestService;
import com.eshop.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.jsondoc.core.annotation.ApiHeader;
import org.jsondoc.core.annotation.ApiHeaders;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiResponseObject;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@RestController
@RequestMapping(value = "/services/order")
public class OrderRestServiceImpl implements OrderRestService {

    @Autowired
    private OrderService orderService;

    @Override
    @RequestMapping(method = RequestMethod.POST)
    @ApiMethod(description = "Fetch Customer Orders", responsestatuscode = "200 - OK")
    @ApiHeaders(headers = {
            @ApiHeader(name = ACCEPT),
            @ApiHeader(name = CONTENT_TYPE)
    })
    @ResponseStatus(HttpStatus.OK)
    public OrderBean createOrder(@RequestBody OrderBean orderBean) {
        return orderService.createOrder(orderBean);
    }
}
