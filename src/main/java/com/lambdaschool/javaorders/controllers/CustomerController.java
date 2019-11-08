package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/orders",
                produces = {"application/json"})
    public ResponseEntity<?> listAllOrders() {
        List<Customers> myCustomers = customerService.findAllCustomers();
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }

    @GetMapping(value = "/customer/{id}",
                produces = {"application/json"})
    public ResponseEntity<?> findCustomerById(@PathVariable long id) {
        Customers myCustomer = customerService.findCustomerById(id);
        return new ResponseEntity<>(myCustomer, HttpStatus.OK);
    }

    @GetMapping(value = "namelike/{namelike}",
                produces = {"application/json"})
    public ResponseEntity<?> findCustomerByName(@PathVariable String namelike) {
        List<Customers> myCustomers = customerService.findCustomerByNameLike(namelike);
        return new ResponseEntity<>(myCustomers, HttpStatus.OK);
    }
}