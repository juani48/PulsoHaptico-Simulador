package com.pulsohaptico.bridge.builder.dataset.strategy;

import com.pulsohaptico.bridge.model.dataset.Dataset;

public class HighStateStrategy implements StateStrategy {
    @Override
    public void setState(Dataset dataset) {
        dataset.setState(100.0);
    }
}
