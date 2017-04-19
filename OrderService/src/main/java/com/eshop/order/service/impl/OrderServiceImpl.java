package com.eshop.order.service.impl;

import com.eshop.common.beans.Event;
import com.eshop.common.beans.OrderBean;
import com.eshop.common.enums.OrderStatus;
import com.eshop.order.domain.Order;
import com.eshop.order.domain.OrderDetails;
import com.eshop.order.repository.OrderRepository;
import com.eshop.order.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by arun_subramonian on 12/19/16.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Mapper mapper;

    @Resource
    private OrderRepository orderRepository;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public OrderBean findOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        OrderBean orderBean = mapper.map(order, OrderBean.class);
        return orderBean;
    }

    @Override
    @Transactional
    public OrderBean createOrder(OrderBean orderBean) {
        Order order = updateOrderDetails(orderBean);
        order = orderRepository.save(order);
        broadcastOrderCreatedEvent(order);
        return mapper.map(order, OrderBean.class);
    }

    @Override
    @Transactional
    public void updateOrderStatus(Long orderId, OrderStatus orderStatus) {
        Order order = orderRepository.findOne(orderId);
        order.setStatus(orderStatus);
        orderRepository.save(order);
    }

    private void broadcastOrderCreatedEvent(Order order) {
        Event event = new Event();
        event.setOrderId(order.getId());
        event.setCustomerId(order.getCustomerId());
        try {
            kafkaTemplate.send("ORDER_CREATED", objectMapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private Order updateOrderDetails(OrderBean orderBean) {
        Order orderCreated = mapper.map(orderBean, Order.class);
        for (Long productId: orderBean.getProductIds()) {
            OrderDetails orderDetail = new OrderDetails();
            orderDetail.setProductId(productId);
            orderDetail.setOrder(orderCreated);
            orderCreated.getOrderDetails().add(orderDetail);
        }
        return orderCreated;
    }

}
