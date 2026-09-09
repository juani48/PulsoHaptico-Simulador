package com.pulsohaptico.bridge.builder.dataset;

import com.pulsohaptico.bridge.builder.dataset.strategy.EventStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.SensingStrategy;
import com.pulsohaptico.bridge.builder.dataset.strategy.StateStrategy;
import com.pulsohaptico.bridge.model.dataset.Dataset;
public abstract class AbstractDatasetBuilder {
    protected StateStrategy stateStrategy;
    protected EventStrategy eventStrategy;
    protected SensingStrategy sensingStrategy;
    protected AbstractDatasetBuilder(StateStrategy stateStrategy, EventStrategy eventStrategy, SensingStrategy sensingStrategy) {
        this.stateStrategy = stateStrategy;
        this.eventStrategy = eventStrategy;
        this.sensingStrategy = sensingStrategy;
    }
    public Dataset build() {
        Dataset dataset = new Dataset();
        setEvent(dataset);
        setLastSensing(dataset);
        setState(dataset);
        return dataset;
    }
    private void setEvent(Dataset dataset) {
        this.eventStrategy.setEvent(dataset);
    }
    private void setLastSensing(Dataset dataset){
        this.sensingStrategy.setLastSensing(dataset);
    }
    private void setState(Dataset dataset) {
        this.stateStrategy.setState(dataset);
    }
}
