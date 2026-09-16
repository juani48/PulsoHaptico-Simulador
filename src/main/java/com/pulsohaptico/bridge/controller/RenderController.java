package com.pulsohaptico.bridge.controller;

import com.pulsohaptico.bridge.model.Scenario;
import com.pulsohaptico.bridge.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RenderController {
    private final ScenarioService scenarioService;

    @GetMapping("/")
    public String index(Model model) {
        addPageData(model);
        return "index";
    }

    @PostMapping("/set-scenario")
    public String setScenario(@RequestParam Long id) {
        scenarioService.select(id);
        return "redirect:/";
    }

    @PostMapping("/set-vitals")
    public ResponseEntity<Void> setVitals(
            @RequestParam double pulse,
            @RequestParam double state
    ) {
            if (pulse < 40 || pulse > 180 || state < 0 || state > 100) {
                return ResponseEntity.badRequest().build();
            }
            scenarioService.setVitals(pulse, state);
            return ResponseEntity.ok().build();
    }

    private void addPageData(Model model) {
            Scenario selectedScenario = scenarioService.getSelectedScenario();
            model.addAttribute("scenarios", scenarioService.findAll());
            model.addAttribute("selectedScenario", selectedScenario);
            model.addAttribute("pulse", scenarioService.getPulse());
            model.addAttribute("state", scenarioService.getState());
    }
}
