package com.pulsohaptico.bridge.builder.dataset;


import com.pulsohaptico.bridge.builder.dataset.strategy.AncientSensingStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.HighStateStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.OnEventStrategy;

public class DatasetBuilderHSOEAS extends AbstractDatasetBuilder {

    public DatasetBuilderHSOEAS() {
        super(
                new HighStateStrategy(),
                new OnEventStrategy(),
                new AncientSensingStrategy()
        );
    }
}
