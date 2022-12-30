package pl.graczyk.trainingassistant.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import pl.graczyk.trainingassistant.domain.bodypart.BodypartService;
import pl.graczyk.trainingassistant.domain.bodypart.dto.BodypartDto;
import pl.graczyk.trainingassistant.domain.exercise.ExerciseService;
import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;

import java.util.List;

@Controller
public class BodypartController {
    private final BodypartService bodypartService;
    private final ExerciseService exerciseService;

    public BodypartController(BodypartService bodypartService, ExerciseService exerciseService) {
        this.bodypartService = bodypartService;
        this.exerciseService = exerciseService;
    }

    @GetMapping("/partia/{name}")
    public String getBodypart (@PathVariable String name, Model model) {
        BodypartDto bodypart = bodypartService.findBodypartByName(name)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
        List<ExerciseDto> exercises = exerciseService.findExercisesByBodypart(name);
        model.addAttribute("heading", bodypart.getName());
        model.addAttribute("description", bodypart.getDescribtion());
        model.addAttribute("exercises", exercises);
        return "main-page";
    }
}
