package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Customers;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomerRepository extends CrudRepository<Customers, Long> {
    ArrayList<Customers> findByCustnameContainingIgnoringCase(String namelike);
}
