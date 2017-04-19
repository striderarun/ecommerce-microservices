package com.eshop.user.rest;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;

import java.util.List;

/**
 * Created by arun_subramonian on 12/18/16.
 */
public interface CustomerRestService {

    CustomerBean fetchCustomerDetails(Long id);

    List<CustomerOrdersBean> fetchCustomerOrders(Long id);

    CustomerBean addCustomer(CustomerBean customer);
}
