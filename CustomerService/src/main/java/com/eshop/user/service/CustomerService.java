package com.eshop.user.service;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.enums.OrderStatus;
import com.eshop.user.domain.Customer;
import com.eshop.user.domain.CustomerOrders;

import java.util.List;

/**
 * Created by arun_subramonian on 12/18/16.
 */
public interface CustomerService {

    CustomerBean fetchCustomerDetails(Long id);

    List<CustomerOrdersBean> fetchCustomerOrders(Long customerId);

    CustomerOrdersBean fetchCustomerOrder(Long orderId);

    CustomerBean addCustomer(CustomerBean customer);

    void createCustomerOrder(CustomerOrdersBean customerOrders);

    void updateCustomerOrderStatus(Long orderId, OrderStatus orderStatus);


}
