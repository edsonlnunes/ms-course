package br.com.developerspills.hrpayroll.controllers;

import br.com.developerspills.hrpayroll.entities.Payment;
import br.com.developerspills.hrpayroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/{workerUid}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable UUID workerUid, @PathVariable int days){
        var payment = paymentService.getPayment(workerUid, days);
        return ResponseEntity.ok(payment);
    }
}
