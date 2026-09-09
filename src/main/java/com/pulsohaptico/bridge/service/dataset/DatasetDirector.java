package com.pulsohaptico.bridge.service.dataset;

import com.pulsohaptico.bridge.builder.dataset.*;
import com.pulsohaptico.bridge.builder.dataset.strategy.DatasetBuilderLSNERS;
import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.model.dataset.DatasetType;
import org.springframework.stereotype.Service;

@Service
public class DatasetDirector {
    public Dataset build(DatasetType datasetType) {
        switch (datasetType) {
            case HSNEAS:
                return new DatasetBuilderHSNEAS().build();
            case HSNERS:
                return new DatasetBuilderHSNERS().build();
            case LSNEAS:
                return new DatasetBuilderLSNEAS().build();
            case LSNERS:
                return new DatasetBuilderLSNERS().build();
            case HSOEAS:
                return new DatasetBuilderHSOEAS().build();
            case LSOEAS:
                return new DatasetBuilderLSOEAS().build();
            default:
                throw new IllegalArgumentException("Unknown dataset type: " + datasetType);
        }
    }
}
