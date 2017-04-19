package com.eshop.user.service.impl;

import com.eshop.common.beans.CustomerBean;
import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.enums.OrderStatus;
import com.eshop.user.domain.Customer;
import com.eshop.user.domain.CustomerOrders;
import com.eshop.user.repository.CustomerOrderRepository;
import com.eshop.user.repository.CustomerRepository;
import com.eshop.user.service.CustomerService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arun_subramonian on 12/18/16.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerRepository customerRepository;

    @Resource
    private CustomerOrderRepository customerOrderRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public CustomerBean fetchCustomerDetails(Long id) {
        Customer customer = customerRepository.findOne(id);
        return mapper.map(customer, CustomerBean.class);
    }

    @Override
    public List<CustomerOrdersBean> fetchCustomerOrders(Long customerId) {
        List<CustomerOrders> customerOrders = customerOrderRepository.findByCustomerId(customerId);
        List<CustomerOrdersBean> customerOrderBeans = customerOrders.stream().map( s -> mapper.map(s, CustomerOrdersBean.class)).collect(Collectors.toList());
        return customerOrderBeans;
    }

    @Override
    public CustomerOrdersBean fetchCustomerOrder(Long orderId) {
        CustomerOrders customerOrder = customerOrderRepository.findByOrderId(orderId);
        return mapper.map(customerOrder, CustomerOrdersBean.class);
    }

    @Override
    @Transactional
    public void createCustomerOrder(CustomerOrdersBean customerOrders) {
        CustomerOrders customerOrder = mapper.map(customerOrders, CustomerOrders.class);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    @Transactional
    public void updateCustomerOrderStatus(Long orderId, OrderStatus orderStatus) {
        CustomerOrders customerOrder = customerOrderRepository.findByOrderId(orderId);
        customerOrder.setOrderStatus(orderStatus);
        customerOrderRepository.save(customerOrder);
    }

    @Override
    @Transactional
    public CustomerBean addCustomer(CustomerBean customerBean) {
        Customer customer = mapper.map(customerBean, Customer.class);
        customer = customerRepository.save(customer);
        return mapper.map(customer, CustomerBean.class);
    }
}
