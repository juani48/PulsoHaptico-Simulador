package com.pulsohaptico.bridge.decorator.structure;

import com.pulsohaptico.bridge.model.dataset.Dataset;

public class DatasetComponent implements Component<Dataset> {
    @Override
    public Dataset getData() {
        return new Dataset();
    }
}
