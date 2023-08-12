package br.com.developerspills.hrworker.controllers;

import br.com.developerspills.hrworker.dtos.WorkerResponse;
import br.com.developerspills.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/workers")
public class WorkerController {

    private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> loadWorkers(){
        var workers = workerRepository.findAll().stream().map(WorkerResponse::new).toList();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("{uid}")
    public ResponseEntity<WorkerResponse> loadWorker(@PathVariable UUID uid){

        logger.info("PORT = "  + env.getProperty("local.server.port"));

        var resultOptional = workerRepository.findById(uid);

        if(resultOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var worker = new WorkerResponse(resultOptional.get());

        return ResponseEntity.ok(worker);
    }
}
