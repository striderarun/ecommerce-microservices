package com.eshop.gateway.repository;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.beans.OrderBean;
import com.eshop.common.beans.ProductBean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by arun_subramonian on 12/23/16.
 */
public interface GatewayRepository {

    CustomerBean fetchCustomerDetails(Long id);

    List<CustomerOrdersBean> fetchCustomerOrders(Long id);

    CustomerBean addCustomer(CustomerBean customer);

    List<ProductBean> fetchAllProducts();

    OrderBean createOrder(OrderBean orderBean);

    void createShipping(Long id);

    void acknowledgeDelivery(Long shippingId);

}
