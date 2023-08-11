package br.com.developerspills.hrworker.repositories;

import br.com.developerspills.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkerRepository extends JpaRepository<Worker, UUID> {
}
