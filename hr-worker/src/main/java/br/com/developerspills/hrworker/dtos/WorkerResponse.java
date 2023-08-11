package br.com.developerspills.hrworker.dtos;

import br.com.developerspills.hrworker.entities.Worker;

import java.util.UUID;

public record WorkerResponse(
        UUID uid,
        String name,
        double dailyIncome
) {
    public WorkerResponse(Worker worker){
        this(worker.getUid(), worker.getName(), worker.getDailyIncome());
    }
}
