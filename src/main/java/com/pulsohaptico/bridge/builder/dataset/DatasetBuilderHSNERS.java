package com.pulsohaptico.bridge.builder.dataset;

import com.pulsohaptico.bridge.builder.dataset.strategy.HighStateStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.NoEventStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.RecentSensingStrategy;

public class DatasetBuilderHSNERS extends AbstractDatasetBuilder {
    public DatasetBuilderHSNERS() {
        super(
                new HighStateStrategy(),
                new NoEventStrategy(),
                new RecentSensingStrategy()
        );
    }
}
