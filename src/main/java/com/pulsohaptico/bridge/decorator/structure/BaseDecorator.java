package com.pulsohaptico.bridge.decorator.structure;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseDecorator<T> implements Component<T> {
    protected Component<T> component;
    @Override
    public T getData() {
        return component.getData();
    }
}
