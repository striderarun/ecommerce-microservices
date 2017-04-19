package com.eshop.common.beans;

import com.eshop.common.enums.OrderStatus;

import java.util.Set;

/**
 * Created by arun_subramonian on 12/23/16.
 */
public class ProductBean {

    private Long id;
    private String name;
    private String price;
    private String category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
