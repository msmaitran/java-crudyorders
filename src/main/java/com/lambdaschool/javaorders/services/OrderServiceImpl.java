package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Orders;
import com.lambdaschool.javaorders.models.Payments;
import com.lambdaschool.javaorders.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "orderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderrepo;

    private PaymentService paymentService;

    @Transactional
    @Override
    public List<Orders> findAllOrders() {

        List<Orders> list = new ArrayList<>();
        orderrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Orders findOrderById(long id) {
        return orderrepo.findById(id).orElseThrow(() ->
                new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public Orders save(Orders orders) {

        Orders newOrder = new Orders();

        newOrder.setOrdamount(orders.getOrdamount());
        newOrder.setAdvanceamount(orders.getAdvanceamount());
        newOrder.setOrderdescription(orders.getOrderdescription());
        newOrder.setCustomers(orders.getCustomers());

        for (Payments p : orders.getPayments()) {
            Payments newPayment = paymentService.findPaymentById(p.getPaymentid());
            newOrder.addPayments(newPayment);
        }

        return orderrepo.save(newOrder);
    }

    @Transactional
    @Override
    public Orders update(Orders orders, long ordnum) {

        Orders currentOrder = findOrderById(ordnum);

        if (orders.hasordamount) {
            currentOrder.setOrdamount(orders.getOrdamount());
        }

        if (orders.hasadvanceamount) {
            currentOrder.setAdvanceamount(orders.getAdvanceamount());
        }

        if (orders.getCustomers() != null) {
            currentOrder.setCustomers(orders.getCustomers());
        }

        if (orders.getOrderdescription() != null) {
            currentOrder.setOrderdescription(orders.getOrderdescription());
        }

        return orderrepo.save(currentOrder);
    }

    @Override
    public void delete(long ordnum) {
        if (findOrderById(ordnum) != null) {
            orderrepo.deleteById(ordnum);
        }
    }
}
