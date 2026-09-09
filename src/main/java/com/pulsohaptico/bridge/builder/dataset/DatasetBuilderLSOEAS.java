package com.pulsohaptico.bridge.builder.dataset;

import com.pulsohaptico.bridge.builder.dataset.strategy.AncientSensingStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.LowStateStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.OnEventStrategy;

public class DatasetBuilderLSOEAS extends AbstractDatasetBuilder {
    public  DatasetBuilderLSOEAS() {
        super(
                new LowStateStrategy(),
                new OnEventStrategy(),
                new AncientSensingStrategy()
        );
    }
}
