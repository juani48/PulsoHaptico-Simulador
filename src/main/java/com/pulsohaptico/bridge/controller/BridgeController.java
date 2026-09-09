package com.pulsohaptico.bridge.controller;

import com.pulsohaptico.bridge.dto.MeasurementResponse;
import com.pulsohaptico.bridge.dto.DatasetResponse;
import com.pulsohaptico.bridge.dto.Response;
import com.pulsohaptico.bridge.service.dataset.DatasetService;
import com.pulsohaptico.bridge.service.measurement.MeasurementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController("/api")
@Tag(name = "Bridge", description = "Operaciones para consultar el estado del bridge")
public class BridgeController {
    private final MeasurementService measurementService;
    private final DatasetService datasetService;

    // Base44 llama a esto (por polling) para leer el estado actual
    @GetMapping("/get-data")
    @Operation(summary = "Consultar las mediciones y el contexto", description = "Devuelve el timepo actual, el pulso y el avento activo, el estado de la persona y el ultimo sensado.")
    public ResponseEntity<Response> state() {
        return ResponseEntity.ok(new Response(
                new MeasurementResponse(measurementService.getDeviceMeasurement()),
                new DatasetResponse(datasetService.getDataset())));
    }
}
