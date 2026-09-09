package com.pulsohaptico.bridge.service.dataset;

import com.pulsohaptico.bridge.decorator.dataset.*;
import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.model.dataset.DatasetType;
import com.pulsohaptico.bridge.decorator.structure.DatasetComponent;
import org.springframework.stereotype.Service;

@Service
public class DatasetBuilder {
    public Dataset build(DatasetType datasetType) {
        switch (datasetType) {
            case HSNEAS:
                return new HighStateDecorator(new NotOnEventDecorator(new AncientSensingDecorator(new DatasetComponent()))).getData();
            case HSNERS:
                return new HighStateDecorator(new NotOnEventDecorator(new RecentSensing(new DatasetComponent()))).getData();
            case LSNEAS:
                return new LowStateDecorator(new NotOnEventDecorator(new AncientSensingDecorator(new DatasetComponent()))).getData();
            case LSNERS:
                return new LowStateDecorator(new NotOnEventDecorator(new RecentSensing(new DatasetComponent()))).getData();
            case HSOEAS:
                return new HighStateDecorator(new OnEventDecorator(new AncientSensingDecorator(new DatasetComponent()))).getData();
            case LSOEAS:
                return new LowStateDecorator(new OnEventDecorator(new AncientSensingDecorator(new DatasetComponent()))).getData();
            default:
                throw new IllegalArgumentException("Unknown dataset type: " + datasetType);
        }
    }
}
