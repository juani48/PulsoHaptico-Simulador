package com.pulsohaptico.bridge.service.dataset;

import com.pulsohaptico.bridge.model.dataset.Dataset;
import com.pulsohaptico.bridge.model.dataset.DatasetType;
import org.springframework.stereotype.Service;

@Service
public class DatasetService {
    private Dataset dataset;
    private DatasetType datasetType;
    private final DatasetBuilder datasetBuilder;
    public  DatasetService(DatasetBuilder datasetBuilder) {
        this.datasetBuilder = datasetBuilder;
        this.setDataset(DatasetType.HSNEAS);
    }

    public void setDataset(DatasetType datasetType) {
        this.dataset = datasetBuilder.build(datasetType);
        this.datasetType = datasetType;
    }

    public DatasetType getDatasetType() { return this.datasetType; }
    public Dataset getDataset() { return this.dataset; }
}
