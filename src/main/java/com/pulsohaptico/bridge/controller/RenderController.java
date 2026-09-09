package com.pulsohaptico.bridge.controller;

import com.pulsohaptico.bridge.model.dataset.DatasetType;
import com.pulsohaptico.bridge.model.measurement.MeasurementType;
import com.pulsohaptico.bridge.service.dataset.DatasetService;
import com.pulsohaptico.bridge.service.measurement.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class RenderController {
    private static final List<MeasurementType> SCENARIO_TYPES = List.of(MeasurementType.values());
    private static final List<DatasetType> DATASET_TYPES = List.of(DatasetType.values());

    private final MeasurementService measurementService;
    private final DatasetService datasetService;

    @GetMapping("/")
    public String index(Model model) {
        addPageData(model);
        return "index";
    }

    @PostMapping("/set-measurement")
    public String setScenario(@RequestParam MeasurementType type, Model model) {
        try {
            measurementService.setScenario(type);
            return "redirect:/";
        } catch (IllegalArgumentException e) {
            addPageData(model);
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }

    @PostMapping("/set-dataset")
    public String setDataset(@RequestParam DatasetType type, Model model) {
        datasetService.setDataset(type);
        return "redirect:/";
    }

    private void addPageData(Model model) {
        addScenarioData(model);
        model.addAttribute("datasetTypes", DATASET_TYPES);
        model.addAttribute("selectedDataset", datasetService.getDatasetType());
    }

    private void addScenarioData(Model model) {
        model.addAttribute("scenarioTypes", SCENARIO_TYPES);
        model.addAttribute("selectedScenario", measurementService.getScenarioType());
    }
}
