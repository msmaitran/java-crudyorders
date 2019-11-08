package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> findAllOrders();

    Orders findOrderById(long id);

    Orders save(Orders orders);

    Orders update(Orders orders, long ordnum);

    void delete (long ordnum);
}
