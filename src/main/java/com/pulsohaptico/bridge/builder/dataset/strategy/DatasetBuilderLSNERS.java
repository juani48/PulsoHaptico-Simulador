package com.pulsohaptico.bridge.builder.dataset.strategy;

import com.pulsohaptico.bridge.builder.dataset.AbstractDatasetBuilder;

public class DatasetBuilderLSNERS extends AbstractDatasetBuilder {
    public DatasetBuilderLSNERS() {
        super(
                new LowStateStrategy(),
                new NoEventStrategy(),
                new RecentSensingStrategy()
        );
    }
}
