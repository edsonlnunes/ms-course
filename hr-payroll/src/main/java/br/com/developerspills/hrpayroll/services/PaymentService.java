package br.com.developerspills.hrpayroll.services;

import br.com.developerspills.hrpayroll.dtos.Worker;
import br.com.developerspills.hrpayroll.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class PaymentService {

    @Value("${hr-worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(UUID workerUid, int days){

        var url = workerHost + "/api/workers/" + workerUid.toString();

        var worker = restTemplate.getForObject(url, Worker.class);

        return new Payment(worker.name(), worker.dailyIncome(), days);
    }
}
