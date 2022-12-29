package pl.graczyk.trainingassistant.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.graczyk.trainingassistant.domain.exercise.ExerciseService;
import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;

import java.util.Optional;

@Controller
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
    @GetMapping("/cwiczenia/{id}")
    public String getExercise(@PathVariable long id, Model model) {
        Optional<ExerciseDto> optionalExercise = exerciseService.findExerciseById(id);
        optionalExercise.ifPresent(exercise -> model.addAttribute("exercise", exercise));
    return "exercise";
    }
}
