package com.eshop.user.repository;

import com.eshop.user.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by arun_subramonian on 12/18/16.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
