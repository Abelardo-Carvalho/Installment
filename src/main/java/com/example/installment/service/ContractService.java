package com.example.installment.service;

import com.example.installment.model.Contract;
import com.example.installment.model.Installment;

import java.util.Calendar;
import java.util.Date;

public class ContractService {

    OnlinePaymentService onlinePaymentService;

    public ContractService (OnlinePaymentService onlinePaymentService){
        this.onlinePaymentService = onlinePaymentService;
        // INVERSÃO DE CONTROLE ATRAVÉS DO CONSTRUTOR, MAS PODERIA TER SIDO REALIZADA COM @AUTOWIRED
    }

    public void processContract (Contract contract, int months){
        double basicQuota = contract.getTotalValue()/months;
        for (int i = 1; i <= months; i++){
            double updateQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
            double fullQuota = updateQuota + onlinePaymentService.paymentFee(updateQuota);
            Date dueDate = addMonths(contract.getDate(), i);
            contract.getInstallments().add(new Installment(dueDate, fullQuota));
        }

    }
    private Date addMonths (Date date, int N){
        Calendar calendar = Calendar.getInstance(); //Cria a instancia do calendar
        calendar.setTime(date); //Adiciona a data inicial
        calendar.add(Calendar.MONTH, N); //Adiciona N meses a data
        return calendar.getTime();
    }
}
