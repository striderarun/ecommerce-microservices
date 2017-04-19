package com.eshop.gateway.repository.impl;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.beans.OrderBean;
import com.eshop.common.beans.ProductBean;
import com.eshop.gateway.client.CustomerClient;
import com.eshop.gateway.client.OrderClient;
import com.eshop.gateway.client.ProductClient;
import com.eshop.gateway.client.ShippingClient;
import com.eshop.gateway.repository.GatewayRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by arun_subramonian on 12/23/16.
 */
@Repository
public class GatewayRepositoryImpl implements GatewayRepository {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private OrderClient orderClient;

    @Autowired
    private ShippingClient shippingClient;

    @Override
    public CustomerBean fetchCustomerDetails(Long id) {
        return customerClient.fetchCustomerDetails(id);
    }

    @Override
    public List<CustomerOrdersBean> fetchCustomerOrders(Long id) {
        return customerClient.fetchCustomerOrders(id);
    }

    @Override
    public CustomerBean addCustomer(CustomerBean customer) {
        return customerClient.addCustomer(customer);
    }

    @Override
    public List<ProductBean> fetchAllProducts() {
        return productClient.fetchAllProducts();
    }

    @Override
    public OrderBean createOrder(OrderBean orderBean) {
        return orderClient.createOrder(orderBean);
    }

    @Override
    public void createShipping(Long id) {
        shippingClient.createShipping(id);
    }

    @Override
    public void acknowledgeDelivery(Long shippingId) {
        shippingClient.acknowledgeDelivery(shippingId);
    }

}
