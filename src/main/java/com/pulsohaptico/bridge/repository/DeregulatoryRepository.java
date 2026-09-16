package com.pulsohaptico.bridge.repository;

import com.pulsohaptico.bridge.model.Deregulatory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeregulatoryRepository extends JpaRepository<Deregulatory, Long> {
}