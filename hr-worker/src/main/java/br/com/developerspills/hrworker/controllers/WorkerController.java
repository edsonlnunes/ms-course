package br.com.developerspills.hrworker.controllers;

import br.com.developerspills.hrworker.dtos.WorkerResponse;
import br.com.developerspills.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<WorkerResponse>> loadWorkers(){
        var workers = workerRepository.findAll().stream().map(WorkerResponse::new).toList();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("{uid}")
    public ResponseEntity<WorkerResponse> loadWorker(@PathVariable UUID uid){
        var resultOptional = workerRepository.findById(uid);

        if(resultOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        var worker = new WorkerResponse(resultOptional.get());

        return ResponseEntity.ok(worker);
    }
}
