package com.example.demoservice.repository;

import com.example.demoservice.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource

public interface CommandRepository extends JpaRepository<Command, Long> {
}
