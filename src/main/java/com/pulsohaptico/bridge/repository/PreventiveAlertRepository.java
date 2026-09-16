package com.pulsohaptico.bridge.repository;

import com.pulsohaptico.bridge.model.PreventiveAlert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreventiveAlertRepository extends JpaRepository<PreventiveAlert, Long> {
}