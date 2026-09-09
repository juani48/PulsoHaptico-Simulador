package com.pulsohaptico.bridge.builder.dataset.strategy;

import com.pulsohaptico.bridge.model.dataset.Dataset;

import java.time.OffsetDateTime;

public class NoEventStrategy implements EventStrategy {
    @Override
    public void setEvent(Dataset dataset) {
        dataset.setStartEvent(OffsetDateTime.now().minusDays(1));
        dataset.setEndEvent(OffsetDateTime.now().minusDays(1).plusHours(1));
    }
}
