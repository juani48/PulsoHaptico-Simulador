package com.pulsohaptico.bridge.dto;

import com.pulsohaptico.bridge.model.RegulationStrategy;
import lombok.Data;

@Data
public class RegulationStrategyResponse {
    private String description;

    public RegulationStrategyResponse(RegulationStrategy regulationStrategy) {
        this.description = regulationStrategy.getDescription();
    }
}
