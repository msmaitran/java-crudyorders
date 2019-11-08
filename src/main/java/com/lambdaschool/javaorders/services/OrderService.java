package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Orders;

public interface OrderService {
    Orders findOrderById(long id);
}
