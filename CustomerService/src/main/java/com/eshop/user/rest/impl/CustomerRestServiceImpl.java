package com.eshop.user.rest.impl;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.user.rest.CustomerRestService;
import com.eshop.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by arun_subramonian on 12/18/16.
 */
@RestController
@RequestMapping(value = "/services/customer")
public class CustomerRestServiceImpl implements CustomerRestService {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value= "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public CustomerBean fetchCustomerDetails(@PathVariable Long id) {
        return customerService.fetchCustomerDetails(id);
    }

    @RequestMapping(value= "/{id}/orders", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerOrdersBean> fetchCustomerOrders(@PathVariable Long id) {
        return customerService.fetchCustomerOrders(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public CustomerBean addCustomer(@RequestBody CustomerBean customer) {
        return customerService.addCustomer(customer);
    }
}
