package com.lambdaschool.javaorders.controllers;

import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping(value = "/customer",
                 produces = {"application/json"})
    public ResponseEntity<?> addNewCustomer(@Valid
                                            @RequestBody Customers newCustomer) {
        newCustomer = customerService.save(newCustomer);

        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomersURI = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{customerid}")
                .buildAndExpand(newCustomer.getCustcode())
                .toUri();

        responseHeaders.setLocation(newCustomersURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customer/{custcode}",
                produces = {"application/json"})
    public ResponseEntity<?> updateCustomer(@RequestBody Customers updateCustomer,
                                            @PathVariable long custcode) {
        customerService.update(updateCustomer, custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/customer/{custcode}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long custcode) {
        customerService.delete(custcode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}