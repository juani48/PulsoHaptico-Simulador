package com.pulsohaptico.bridge.builder.dataset;

import com.pulsohaptico.bridge.builder.dataset.strategy.AncientSensingStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.LowStateStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.NoEventStrategy;
public class DatasetBuilderLSNEAS extends AbstractDatasetBuilder {
    public  DatasetBuilderLSNEAS() {
        super(new LowStateStrategy(), new NoEventStrategy(), new AncientSensingStrategy());
    }
}
