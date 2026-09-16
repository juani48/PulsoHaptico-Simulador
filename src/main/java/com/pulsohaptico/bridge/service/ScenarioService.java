package com.pulsohaptico.bridge.service;

import com.pulsohaptico.bridge.model.Scenario;
import com.pulsohaptico.bridge.repository.ScenarioRepository;
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

    public Scenario getSelectedScenario() {
        if (selectedScenario == null) {
            scenarioRepository.findAll().stream().findFirst()
                    .ifPresent(scenario -> select(scenario.getId()));
        }
        return selectedScenario;
    }

    public void select(Long id) {
        Scenario scenario = scenarioRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Escenario no encontrado: " + id)
        );
        selectedScenario = scenario;
        pulse = scenario.getBasePulse();
        state = scenario.getBaseState() * 100;
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
