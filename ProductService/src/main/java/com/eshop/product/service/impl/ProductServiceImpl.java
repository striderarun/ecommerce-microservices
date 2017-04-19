package com.eshop.product.service.impl;

import com.eshop.common.beans.ProductBean;
import com.eshop.product.domain.Product;
import com.eshop.product.repository.ProductRepository;
import com.eshop.product.service.ProductService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by arun_subramonian on 12/19/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public List<ProductBean> fetchAllProducts() {
        return productRepository.findAll().stream().map(s -> mapper.map(s, ProductBean.class)).collect(Collectors.toList());
    }
}
