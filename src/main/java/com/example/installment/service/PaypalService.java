package com.example.installment.service;

public class PaypalService implements OnlinePaymentService {


    @Override
    public double paymentFee() {
        return 0;
    }

    @Override
    public double interest(double amount, int months) {
        return 0;
    }
}
