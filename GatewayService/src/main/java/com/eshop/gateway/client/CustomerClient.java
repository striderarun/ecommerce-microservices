package com.eshop.gateway.client;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by arun_subramonian on 12/24/16.
 */
@FeignClient("http://customerService")
public interface CustomerClient {

    @RequestMapping(value = "/eshop/services/customer/{id}", method = RequestMethod.GET)
    CustomerBean fetchCustomerDetails(@PathVariable("id") Long id);

    @RequestMapping(value= "/eshop/services/customer/{id}/orders", method = RequestMethod.GET)
    List<CustomerOrdersBean> fetchCustomerOrders(@PathVariable("id") Long id);

    @RequestMapping(value = "/eshop/services/customer", method = RequestMethod.POST)
    CustomerBean addCustomer(@RequestBody CustomerBean customer);
}
