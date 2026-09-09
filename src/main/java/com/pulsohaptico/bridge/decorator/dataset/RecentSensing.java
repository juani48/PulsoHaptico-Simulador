package com.pulsohaptico.bridge.decorator.dataset;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.decorator.structure.BaseDecorator;
import com.pulsohaptico.bridge.decorator.structure.Component;

import java.time.OffsetDateTime;

public class RecentSensing extends BaseDecorator<Dataset> {
    public RecentSensing(Component component) {
        super(component);
    }

    @Override
    public Dataset getData() {
        Dataset dataset = super.getData();
        dataset.setLastSensing(OffsetDateTime.now());
        return dataset;
    }
}
