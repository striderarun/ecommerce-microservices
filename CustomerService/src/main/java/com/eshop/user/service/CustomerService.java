package com.eshop.user.service;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.enums.OrderStatus;
import com.eshop.user.domain.Customer;
import com.eshop.user.domain.CustomerOrders;

import java.util.List;

public interface CustomerService {

    /**
     * Fetch Customer Details By Id
     *
     * @param id
     * @return
     */
    CustomerBean fetchCustomerDetails(Long id);

    /**
     * Fetch Customer Orders
     *
     * @param customerId
     * @return
     */
    List<CustomerOrdersBean> fetchCustomerOrders(Long customerId);

    /**
     * Fetch customer orders
     *
     * @param orderId
     * @return
     */
    CustomerOrdersBean fetchCustomerOrder(Long orderId);

    /**
     * Add Cusotmer
     *
     * @param customer
     * @return
     */
    CustomerBean addCustomer(CustomerBean customer);

    /**
     * Create cusotmer orders
     * @param customerOrders
     */
    void createCustomerOrder(CustomerOrdersBean customerOrders);

    /**
     * Update customer order status
     *
     * @param orderId
     * @param orderStatus
     */
    void updateCustomerOrderStatus(Long orderId, OrderStatus orderStatus);


}
