package com.pulsohaptico.bridge.service;

import com.pulsohaptico.bridge.model.Scenario;
import com.pulsohaptico.bridge.repository.ScenarioRepository;
import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioService {
    private final ScenarioRepository scenarioRepository;
    private Scenario selectedScenario;
    private double pulse;
    private double state;
    public ScenarioService(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }
    public List<Scenario> findAll() {
        return scenarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Scenario getSelectedScenario() {
        if (selectedScenario == null) {
            scenarioRepository.findAll().stream().findFirst()
                    .ifPresent(scenario -> select(scenario.getId()));
        }
        return selectedScenario;
    }

    @Transactional(readOnly = true)
    public void select(Long id) {
        Scenario scenario = scenarioRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Escenario no encontrado: " + id)
        );
        initializeProfileData(scenario);
        selectedScenario = scenario;
        pulse = scenario.getBasePulse();
        state = scenario.getBaseState() * 100;
    }

    private void initializeProfileData(Scenario scenario) {
        Hibernate.initialize(scenario.getProfile().getDeregulations());
        Hibernate.initialize(scenario.getProfile().getRegulationStrategies());
        Hibernate.initialize(scenario.getProfile().getActivities());
    }

    public void setVitals(double pulse, double state) {
        this.pulse = pulse;
        this.state = state;
    }

    public double getPulse() {
        return pulse;
    }

    public double getState() {
        return state;
    }
}
