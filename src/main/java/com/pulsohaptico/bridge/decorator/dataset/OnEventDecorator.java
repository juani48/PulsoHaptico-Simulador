package com.pulsohaptico.bridge.decorator.dataset;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.decorator.structure.BaseDecorator;
import com.pulsohaptico.bridge.decorator.structure.Component;

import java.time.OffsetDateTime;

public class OnEventDecorator extends BaseDecorator<Dataset> {
    public OnEventDecorator(Component component) {
        super(component);
    }

    @Override
    public Dataset getData() {
        Dataset dataset = super.getData();
        dataset.setStartEvent(OffsetDateTime.now());
        dataset.setEndEvent(OffsetDateTime.now().plusHours(1));
        return dataset;
    }
}
