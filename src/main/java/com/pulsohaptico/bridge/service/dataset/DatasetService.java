package com.pulsohaptico.bridge.service.dataset;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.model.dataset.DatasetType;
import org.springframework.stereotype.Service;

@Service
public class DatasetService {
    private Dataset dataset;
    private DatasetType datasetType;
    private final DatasetDirector datasetDirector;
    public  DatasetService(DatasetDirector datasetDirector) {
        this.datasetDirector = datasetDirector;
        this.setDataset(DatasetType.HSNEAS);
    }

    public void setDataset(DatasetType datasetType) {
        this.dataset = datasetDirector.build(datasetType);
        this.datasetType = datasetType;
    }

    public DatasetType getDatasetType() { return this.datasetType; }
    public Dataset getDataset() { return this.dataset; }
}
