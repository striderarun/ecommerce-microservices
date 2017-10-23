package com.eshop.user.rest;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;

import java.util.List;


public interface CustomerRestService {

    /**
    * Fetch Customer Details
    *
    */
    CustomerBean fetchCustomerDetails(Long id);
    
    /**
    * Fetch customer orders
    *
    */
    List<CustomerOrdersBean> fetchCustomerOrders(Long id);
    
    /*
    * Add customer
    *
    */
    CustomerBean addCustomer(CustomerBean customer);
}
