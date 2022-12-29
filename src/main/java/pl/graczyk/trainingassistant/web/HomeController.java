package pl.graczyk.trainingassistant.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.graczyk.trainingassistant.domain.exercise.ExerciseService;
import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;

import java.util.List;

@Controller
public class HomeController {
    private final ExerciseService exerciseService;
    public HomeController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
    @GetMapping("/") public String home(Model model) {
        List<ExerciseDto> promotedExercises = exerciseService.findAllRecommended();
        model.addAttribute("heading", "Proponowane");
        model.addAttribute("description", "Podstawowe ćwiczenia warte zainteresowanania");
        model.addAttribute("exercises", promotedExercises);
        return "main-page";

    }
}