package com.eshop.order.listener;

import com.eshop.common.beans.Event;
import com.eshop.common.beans.OrderBean;
import com.eshop.common.enums.OrderStatus;
import com.eshop.order.domain.Order;
import com.eshop.order.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * Created by arun_subramonian on 12/21/16.
 */
@Component
public class MessageListener {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderService orderService;

    @KafkaListener(topics = "ORDER_SHIPPED")
    public void orderShippedListener(String message) {
        try {
            Event event = objectMapper.readValue(message, Event.class);
            orderService.updateOrderStatus(event.getOrderId(), OrderStatus.SHIPPED);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
