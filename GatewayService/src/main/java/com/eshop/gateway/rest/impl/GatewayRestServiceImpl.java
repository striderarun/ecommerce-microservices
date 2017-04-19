package com.eshop.gateway.rest.impl;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.beans.OrderBean;
import com.eshop.common.beans.ProductBean;
import com.eshop.gateway.repository.GatewayRepository;
import com.eshop.gateway.rest.GatewayRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arun_subramonian on 12/23/16.
 */
@RestController
@RequestMapping(value = "/services/gateway")
public class GatewayRestServiceImpl implements GatewayRestService {

    @Autowired
    private GatewayRepository gatewayRepository;

    @Override
    @RequestMapping(value= "/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public CustomerBean fetchCustomerDetails(@PathVariable Long id) {
        return gatewayRepository.fetchCustomerDetails(id);
    }

    @Override
    @RequestMapping(value= "/customer/{id}/orders", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOrdersBean> fetchCustomerOrders(@PathVariable Long id) {
        return gatewayRepository.fetchCustomerOrders(id);
    }

    @Override
    @RequestMapping(value= "/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public CustomerBean addCustomer(@RequestBody CustomerBean customer) {
        return gatewayRepository.addCustomer(customer);
    }

    @Override
    @RequestMapping(value= "/product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductBean> fetchAllProducts() {
        return gatewayRepository.fetchAllProducts();
    }

    @Override
    @RequestMapping(value= "/order", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public OrderBean createOrder(@RequestBody OrderBean orderBean) {
        return gatewayRepository.createOrder(orderBean);
    }

    @Override
    @RequestMapping(value= "/shipping/order/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createShipping(@PathVariable Long id) {
        gatewayRepository.createShipping(id);
    }

    @Override
    @RequestMapping(value= "/shipping/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void acknowledgeDelivery(@PathVariable Long shippingId) {
        gatewayRepository.acknowledgeDelivery(shippingId);
    }
}
