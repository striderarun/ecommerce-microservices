package com.eshop.gateway.rest;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.beans.OrderBean;
import com.eshop.common.beans.ProductBean;

import java.util.List;

/**
 * Created by arun_subramonian on 12/23/16.
 */
public interface GatewayRestService {

    CustomerBean fetchCustomerDetails(Long id);

    List<CustomerOrdersBean> fetchCustomerOrders(Long id);

    CustomerBean addCustomer(CustomerBean customer);

    List<ProductBean> fetchAllProducts();

    OrderBean createOrder(OrderBean orderBean);

    void createShipping(Long id);

    void acknowledgeDelivery(Long shippingId);


}
