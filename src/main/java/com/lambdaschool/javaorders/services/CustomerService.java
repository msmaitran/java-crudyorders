package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customers;

import java.util.List;

public interface CustomerService {

    List<Customers> findAllCustomers();

    Customers findCustomerById(long id);

    List<Customers> findCustomerByNameLike(String thename);
}
