package br.com.developerspills.hrpayroll.feignclients;


import br.com.developerspills.hrpayroll.dtos.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/api/workers")
public interface WorkerFeignClient {
    @GetMapping("{uid}")
    ResponseEntity<Worker> loadWorker(@PathVariable UUID uid);
}
