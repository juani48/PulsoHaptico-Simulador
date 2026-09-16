package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pulsohaptico.bridge.model.Deregulatory;
import lombok.Data;

@Data
public class DeregulatoryResponse {
    private String description;

    @JsonProperty("alert_threshold")
    private Double alertThreshold;

    @JsonProperty("warning_threshold")
    private Double warningThreshold;

    @JsonProperty("preventive_alert")
    private String preventiveAlert;

    public DeregulatoryResponse(Deregulatory deregulatory) {
        this.description = deregulatory.getDescription();
        this.alertThreshold = deregulatory.getAlertThreshold();
        this.warningThreshold = deregulatory.getWarningThreshold();
        this.preventiveAlert = deregulatory.getPreventiveAlert().getMessage();
    }
}
