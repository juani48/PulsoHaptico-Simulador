package com.pulsohaptico.bridge.repository;

import com.pulsohaptico.bridge.model.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends JpaRepository<Scenario, Long> {
}