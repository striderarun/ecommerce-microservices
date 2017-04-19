package com.eshop.user.listener;

import com.eshop.common.beans.CustomerOrdersBean;
import com.eshop.common.beans.Event;
import com.eshop.common.enums.OrderStatus;
import com.eshop.user.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by arun_subramonian on 12/21/16.
 */
@Component
public class MessageListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerService customerService;


    @KafkaListener(topics = "ORDER_CREATED")
    public void orderCreatedListener(String message) {
        try {
            Event event = objectMapper.readValue(message, Event.class);
            CustomerOrdersBean customerOrder = new CustomerOrdersBean();
            customerOrder.setCustomerId(event.getCustomerId());
            customerOrder.setOrderId(event.getOrderId());
            customerOrder.setOrderStatus(OrderStatus.PLACED);
            customerService.createCustomerOrder(customerOrder);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @KafkaListener(topics = "ORDER_SHIPPED")
    public void orderShippedListener(String message) {
        try {
            Event event = objectMapper.readValue(message, Event.class);
            customerService.updateCustomerOrderStatus(event.getOrderId(), OrderStatus.SHIPPED);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
