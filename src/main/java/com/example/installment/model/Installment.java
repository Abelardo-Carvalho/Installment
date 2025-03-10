package com.example.installment.model;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Installment {

    Date dueDate;
    Double amount;

    public Installment (){}

    public Installment(Date dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Installment{" +
                "dueDate=" + dueDate +
                ", amount=" + amount +
                '}';
    }
}
