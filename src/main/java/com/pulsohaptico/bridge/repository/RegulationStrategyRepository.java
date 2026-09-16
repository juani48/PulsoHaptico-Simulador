package com.pulsohaptico.bridge.repository;

import com.pulsohaptico.bridge.model.RegulationStrategy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegulationStrategyRepository extends JpaRepository<RegulationStrategy, Long> {
}