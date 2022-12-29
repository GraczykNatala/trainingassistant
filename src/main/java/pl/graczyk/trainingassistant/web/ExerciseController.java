package pl.graczyk.trainingassistant.web;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
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
        ExerciseDto exercise = exerciseService.findExerciseById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        model.addAttribute("exercise", exercise);
        return "exercise";
    }
}
