package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Payments;
import com.lambdaschool.javaorders.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityNotFoundException;

public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentrepo;

    @Override
    public Payments findPaymentById(long id) {
        return paymentrepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Payment " + id + " not found"));
    }

    @Override
    public Payments save(Payments payments) {
        return null;
    }
}
