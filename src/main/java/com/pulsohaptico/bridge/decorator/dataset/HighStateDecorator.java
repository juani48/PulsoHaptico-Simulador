package com.pulsohaptico.bridge.decorator.dataset;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.decorator.structure.BaseDecorator;
import com.pulsohaptico.bridge.decorator.structure.Component;

public class HighStateDecorator extends BaseDecorator<Dataset> {
    public HighStateDecorator(Component component) {
        super(component);
    }

    @Override
    public Dataset getData() {
        Dataset dataset = super.getData();
        dataset.setState(100.0);
        return dataset;
    }
}
