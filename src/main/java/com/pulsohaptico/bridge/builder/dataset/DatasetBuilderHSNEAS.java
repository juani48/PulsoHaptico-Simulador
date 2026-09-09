package com.pulsohaptico.bridge.builder.dataset;

import com.pulsohaptico.bridge.builder.dataset.strategy.*;

public class DatasetBuilderHSNEAS extends AbstractDatasetBuilder {
    public DatasetBuilderHSNEAS() {
        super(new HighStateStrategy(), new NoEventStrategy(), new AncientSensingStrategy());
    }
}
