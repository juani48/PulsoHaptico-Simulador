package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pulsohaptico.bridge.model.Activity;
import lombok.Data;

@Data
public class ActivityResponse {
    private String starts;
    private String ends;
    private Double wear;

    @JsonProperty("can_postponed")
    private Boolean canPostponed;

    @JsonProperty("has_warning")
    private Boolean hasWarning;

    public ActivityResponse(Activity activity) {
        this.starts = activity.getStarts().toString();
        this.ends = activity.getEnds().toString();
        this.wear = activity.getWear();
        this.canPostponed = activity.getCanPostponed();
        this.hasWarning = activity.getHasWarning();
    }
}
