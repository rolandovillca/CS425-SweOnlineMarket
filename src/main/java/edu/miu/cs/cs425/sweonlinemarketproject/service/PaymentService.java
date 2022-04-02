package edu.miu.cs.cs425.sweonlinemarketproject.service;

import edu.miu.cs.cs425.sweonlinemarketproject.model.Payment;
import edu.miu.cs.cs425.sweonlinemarketproject.model.Product;

import java.util.List;

public interface PaymentService {

    List<Payment> findAllPayments();

    Payment addNewPayment(Payment payment);

    Payment findPaymentById(long id);

    Payment updateById(long id, Payment payment);

    void deletePaymentById(long id);

}
