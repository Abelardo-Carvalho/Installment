package com.example.installment.service;

import com.example.installment.model.Contract;

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
        }

    }
}
