package com.example.nubedianTest.repository;

import com.example.nubedianTest.model.Processor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessorRepository extends JpaRepository<Processor, String> {

}
