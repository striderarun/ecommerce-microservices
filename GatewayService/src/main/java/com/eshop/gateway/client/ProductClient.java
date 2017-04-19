package com.eshop.gateway.client;

import com.eshop.common.beans.ProductBean;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by arun_subramonian on 12/24/16.
 */
@FeignClient("http://productService")
public interface ProductClient {

    @RequestMapping(value = "/eshop/services/product", method = RequestMethod.GET)
    List<ProductBean> fetchAllProducts();
}
