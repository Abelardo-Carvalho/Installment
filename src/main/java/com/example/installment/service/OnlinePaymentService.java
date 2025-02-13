package com.example.installment.service;

public interface OnlinePaymentService {

    double paymentFee (double amount);
    double interest (double amount, int months);
}
