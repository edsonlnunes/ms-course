package br.com.developerspills.hrpayroll.services;

import br.com.developerspills.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    public Payment getPayment(UUID workerUid, int days){
        return new Payment("Bob Esponja", 200, days);
    }
}
