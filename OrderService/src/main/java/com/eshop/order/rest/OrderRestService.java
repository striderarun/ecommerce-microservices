package com.eshop.order.rest;

import com.eshop.common.beans.OrderBean;
import com.eshop.order.domain.Order;

/**
 * Created by arun_subramonian on 12/19/16.
 */
public interface OrderRestService {

    OrderBean createOrder(OrderBean orderBean);
}
