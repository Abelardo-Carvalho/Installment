package com.example.installment.service;

public class PaypalService implements OnlinePaymentService {

    public static final double payment_fee = 0.02;
    public static final double monthly_interest = 0.01;

    @Override
    public double paymentFee(double amount) {
        return payment_fee * amount;
    }

    @Override
    public double interest(double amount, int months) {
        return amount * months * monthly_interest;
    }
}
