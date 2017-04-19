package com.eshop.product.rest.impl;

import com.eshop.common.beans.ProductBean;
import com.eshop.product.domain.Product;
import com.eshop.product.rest.ProductRestService;
import com.eshop.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by arun_subramonian on 12/19/16.
 */
@RestController
@RequestMapping(value = "/services/product")
public class ProductRestServiceImpl implements ProductRestService {

    @Autowired
    private ProductService productService;

    @Override
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<ProductBean> fetchAllProducts() {
        return productService.fetchAllProducts();
    }
}
