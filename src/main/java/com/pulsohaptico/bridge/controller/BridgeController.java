package com.pulsohaptico.bridge.controller;

import com.pulsohaptico.bridge.dto.Response;
import com.pulsohaptico.bridge.dto.ScenarioResponse;
import com.pulsohaptico.bridge.service.ScenarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@Tag(name = "Bridge", description = "Operaciones para consultar el estado del bridge")
public class BridgeController {
    private final ScenarioService scenarioService;

    // Base44 llama a esto (por polling) para leer el estado actual
    @GetMapping("/get-data")
    @Operation(summary = "Consultar el escenario seleccionado", description = "Devuelve el escenario activo junto con el pulso y estado actuales.")
    public ResponseEntity<Response> state() {
        return ResponseEntity.ok(new Response(new ScenarioResponse(
                scenarioService.getSelectedScenario(),
                scenarioService.getPulse(),
                scenarioService.getState()
        )));
    }
}
