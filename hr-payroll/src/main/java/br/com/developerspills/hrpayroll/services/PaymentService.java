package br.com.developerspills.hrpayroll.services;
import br.com.developerspills.hrpayroll.entities.Payment;
import br.com.developerspills.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(UUID workerUid, int days){
        var worker = workerFeignClient.loadWorker(workerUid).getBody();
        return new Payment(worker.name(), worker.dailyIncome(), days);
    }
}
