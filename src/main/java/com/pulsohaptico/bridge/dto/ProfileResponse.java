package com.pulsohaptico.bridge.dto;

import com.pulsohaptico.bridge.model.Profile;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class ProfileResponse {
    private String name;
    private String description;
    private List<DeregulatoryResponse> deregulations;
    private List<RegulationStrategyResponse> regulationStrategies;
    private List<ActivityResponse> activities;

    public ProfileResponse(Profile profile) {
        this.name = profile.getName();
        this.description = profile.getDescription();
        this.deregulations = profile.getDeregulations().stream().map(DeregulatoryResponse::new).collect(Collectors.toList());
        this.regulationStrategies = profile.getRegulationStrategies().stream().map(RegulationStrategyResponse::new).collect(Collectors.toList());
        this.activities = profile.getActivities().stream().map(ActivityResponse::new).collect(Collectors.toList());
    }
}
