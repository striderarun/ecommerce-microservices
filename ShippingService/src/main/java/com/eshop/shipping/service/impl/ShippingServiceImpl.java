package com.eshop.shipping.service.impl;

import com.eshop.common.beans.Event;
import com.eshop.common.enums.ShippingStatus;
import com.eshop.shipping.domain.Shipping;
import com.eshop.shipping.repository.ShippingRepository;
import com.eshop.shipping.service.ShippingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by arun_subramonian on 12/19/16.
 */
@Service
public class ShippingServiceImpl implements ShippingService {

    @Resource
    private ShippingRepository shippingRepository;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void createShippingRequest(Long orderId) {
        Shipping shipping = new Shipping();
        shipping.setOrderId(orderId);
        shipping.setStatus(ShippingStatus.SHIPPED);
        shipping = shippingRepository.save(shipping);
        broadcastOrderShippedEvent(shipping);
    }

    @Override
    public void acknowledgeDelivery(Long shippingId) {
        Shipping shipping = shippingRepository.findOne(shippingId);
        shipping.setStatus(ShippingStatus.DELIVERED);
        shippingRepository.save(shipping);
    }

    private void broadcastOrderShippedEvent(Shipping shipping) {
        Event event = new Event();
        event.setOrderId(shipping.getOrderId());
        try {
            kafkaTemplate.send("ORDER_SHIPPED", objectMapper.writeValueAsString(event));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
