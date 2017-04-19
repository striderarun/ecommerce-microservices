package com.eshop.product.service;

import com.eshop.common.beans.ProductBean;
import com.eshop.product.domain.Product;

import java.util.List;

/**
 * Created by arun_subramonian on 12/19/16.
 */
public interface ProductService {

    List<ProductBean> fetchAllProducts();


}
