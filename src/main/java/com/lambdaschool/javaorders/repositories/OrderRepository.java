package com.lambdaschool.javaorders.repositories;

import com.lambdaschool.javaorders.models.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Orders, Long> {
}
