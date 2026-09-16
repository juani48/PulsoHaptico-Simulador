package com.pulsohaptico.bridge.seeder;

import com.pulsohaptico.bridge.model.Activity;
import com.pulsohaptico.bridge.model.Deregulatory;
import com.pulsohaptico.bridge.model.PreventiveAlert;
import com.pulsohaptico.bridge.model.Profile;
import com.pulsohaptico.bridge.model.RegulationStrategy;
import com.pulsohaptico.bridge.model.Scenario;
import com.pulsohaptico.bridge.repository.ActivityRepository;
import com.pulsohaptico.bridge.repository.DeregulatoryRepository;
import com.pulsohaptico.bridge.repository.PreventiveAlertRepository;
import com.pulsohaptico.bridge.repository.ProfileRepository;
import com.pulsohaptico.bridge.repository.RegulationStrategyRepository;
import com.pulsohaptico.bridge.repository.ScenarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AppSeeder implements CommandLineRunner {
    private final ProfileRepository profileRepository;
    private final DeregulatoryRepository deregulatoryRepository;
    private final PreventiveAlertRepository preventiveAlertRepository;
    private final RegulationStrategyRepository regulationStrategyRepository;
    private final ActivityRepository activityRepository;
    private final ScenarioRepository scenarioRepository;


    @Override
    public void run(String... args) {
        if (profileRepository.count() > 0) {
            return;
        }

        Profile nd1 = new Profile(
                "ND1",
                "Perfil con alta sensibilidad sensorial: se desregula principalmente por estímulos ambientales (ruido, luces, aglomeración) y por la falta de previsibilidad."
        );
        Profile nd2 = new Profile(
                "ND2",
                "Perfil con desregulación asociada a sobrecarga cognitiva y de tareas: deadlines simultáneos, discusiones sin resolución y baja tolerancia a la frustración."
        );

        addDeregulations(nd1, List.of(
                new LocalDeregulation("murmullo_personas", 0.8, 0.6),
                new LocalDeregulation("luces", 0.8, 0.6),
                new LocalDeregulation("aglomeracion_personas", 0.8, 0.6),
                new LocalDeregulation("situaciones_no_planificadas", 0.5, 0.5),
                new LocalDeregulation("texturas", 0.5, 0.5),
                new LocalDeregulation("usar_calzado", 0.3, 0.3)
        ));
        addDeregulations(nd2, List.of(
                new LocalDeregulation("sobrecarga_actividades", 0.8, 0.8),
                new LocalDeregulation("deadlines_simultaneos", 0.8, 0.8),
                new LocalDeregulation("discusiones_sin_resolucion", 0.5, 0.5),
                new LocalDeregulation("poca_tolerancia_frustracion", 0.8, 0.8),
                new LocalDeregulation("hablar_en_publico", 0.5, 0.5),
                new LocalDeregulation("situaciones_evaluacion", 0.5, 0.5)
        ));

        RegulationStrategy nd1Strategy = saveStrategy(
                "Cuando el bienestar sea menor o igual al 40%, brindar lugares de descanso, proponer un patrón vibrotáctil y proveer música ambiental."
        );
        RegulationStrategy nd2Strategy = saveStrategy(
                "Cuando el pulso sea mayor o igual a 110 BPM, proponer movimientos configurables, respiración y música lofi."
        );
        nd1.getRegulationStrategies().add(nd1Strategy);
        nd2.getRegulationStrategies().add(nd2Strategy);

        Activity anaMeeting = saveActivity(
                "2026-09-09T10:15:00", "2026-09-09T11:15:00", 0.5, false, true
        );
        Activity anaGroupActivity = saveActivity(
                "2026-09-09T14:00:00", "2026-09-09T16:00:00", 1.0, true, true
        );
        Activity brunoDeadlineActivity = saveActivity(
                "2026-09-09T16:30:00", "2026-09-09T18:00:00", 1.0, false, true
        );
        Activity brunoDiscussion = saveActivity(
                "2026-09-09T18:05:00", "2026-09-09T19:00:00", 1.0, false, false
        );
        nd1.getActivities().addAll(List.of(anaMeeting, anaGroupActivity));
        nd2.getActivities().addAll(List.of(brunoDeadlineActivity, brunoDiscussion));

        profileRepository.saveAll(List.of(nd1, nd2));

        saveScenario(
                "Durante reunión de trabajo: murmullo de personas, pulso elevado y bienestar bajo.",
                108, 0.38, nd1
        );
        saveScenario(
                "Antes de actividad grupal: se anticipa una posible exposición a aglomeraciones.",
                88, 0.62, nd1
        );
        saveScenario(
                "Durante actividad individual con tres deadlines simultáneos.",
                116, 0.28, nd2
        );
        saveScenario(
                "Después de una reunión de trabajo con discusión sin resolución.",
                102, 0.33, nd2
        );
    }

    private void addDeregulations(Profile profile, List<LocalDeregulation> definitions) {
        for (LocalDeregulation definition : definitions) {
            PreventiveAlert alert = new PreventiveAlert(
                    "Prestar atención al desregulador: " + definition.description()
            );
            Deregulatory deregulatory = new Deregulatory(
                    definition.description() +  " | threshold: " + definition.threshold1() + " : " + definition.threshold2(),
                    definition.threshold1(),
                    definition.threshold2()
            );
            PreventiveAlert savedAlert = preventiveAlertRepository.save(alert);
            deregulatory.setPreventiveAlert(savedAlert);
            alert.setDeregulatory(deregulatory);
            profile.getDeregulations().add(deregulatoryRepository.save(deregulatory));
        }
    }

    private RegulationStrategy saveStrategy(String description) {
        return regulationStrategyRepository.save(new RegulationStrategy(description));
    }

    private Activity saveActivity(
            String starts, String ends, double wear, boolean canBePostponed, boolean hasWarning
    ) {
        return activityRepository.save(new Activity(
                LocalDateTime.parse(starts),
                LocalDateTime.parse(ends),
                wear,
                canBePostponed,
                hasWarning
        ));
    }

    private void saveScenario(String description, double basePulse, double baseState, Profile profile) {
        scenarioRepository.save(new Scenario(description, basePulse, baseState, profile));
    }
}

record LocalDeregulation(String description, double threshold1, double threshold2) {}