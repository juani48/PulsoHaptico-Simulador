package com.pulsohaptico.bridge.builder.dataset.strategy;

import com.pulsohaptico.bridge.model.dataset.Dataset;

import java.time.OffsetDateTime;

public class OnEventStrategy implements EventStrategy {
    @Override
    public void setEvent(Dataset dataset) {
        dataset.setStartEvent(OffsetDateTime.now());
        dataset.setEndEvent(OffsetDateTime.now().plusHours(1));
    }
}
