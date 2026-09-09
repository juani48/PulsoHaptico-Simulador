package com.pulsohaptico.bridge.builder.dataset.strategy;

import com.pulsohaptico.bridge.model.dataset.Dataset;

import java.time.OffsetDateTime;

public class AncientSensingStrategy implements SensingStrategy {
    @Override
    public void setLastSensing(Dataset dataset) {
        dataset.setLastSensing(OffsetDateTime.now().minusHours(3));
    }
}
