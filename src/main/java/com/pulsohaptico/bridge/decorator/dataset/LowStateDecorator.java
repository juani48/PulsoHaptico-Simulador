package com.pulsohaptico.bridge.decorator.dataset;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.decorator.structure.BaseDecorator;
import com.pulsohaptico.bridge.decorator.structure.Component;

public class LowStateDecorator extends BaseDecorator<Dataset> {
    public LowStateDecorator(Component component) {
        super(component);
    }

    @Override
    public Dataset getData() {
        Dataset dataset = super.getData();
        dataset.setState(40.0);
        return dataset;
    }
}
