package com.pulsohaptico.bridge.decorator.dataset;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.decorator.structure.BaseDecorator;
import com.pulsohaptico.bridge.decorator.structure.Component;

import java.time.OffsetDateTime;

public class NotOnEventDecorator extends BaseDecorator<Dataset> {
    public NotOnEventDecorator(Component component) {
        super(component);
    }

    @Override
    public Dataset getData() {
        Dataset dataset = super.getData();
        dataset.setStartEvent(OffsetDateTime.now().minusDays(1));
        dataset.setEndEvent(OffsetDateTime.now().minusDays(1).plusHours(1));
        return dataset;
    }
}
