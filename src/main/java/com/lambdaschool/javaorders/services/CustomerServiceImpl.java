package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Override
    public List<Customers> findAllCustomers() {
        List<Customers> list = new ArrayList<>();
        customerRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerById(long id) {
        return customerRepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public List<Customers> findCustomerByNameLike(String thename) {
        return customerRepo.findByCustnameContainingIgnoringCase(thename);
    }
}
