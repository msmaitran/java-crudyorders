package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Payments;

public interface PaymentService {
    Payments findPaymentById(long id);

    Payments save(Payments payments);
}
