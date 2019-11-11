package com.bitbyte.cargaraage.api.services;

import com.bitbyte.cargaraage.api.models.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean authorizePayment(Payment payment){
        if(payment.getCvc().equals(648)) {
            return true;
        } else
            return false;
    }
}
