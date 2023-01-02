package pl.graczyk.trainingassistant.web.admin;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.graczyk.trainingassistant.domain.bodypart.BodypartService;
import pl.graczyk.trainingassistant.domain.bodypart.dto.BodypartDto;
import pl.graczyk.trainingassistant.domain.exercise.ExerciseService;
import pl.graczyk.trainingassistant.domain.exercise.dto.ExerciseDto;

import java.util.List;

@Controller
public class ExerciseManagementController {
    private final ExerciseService exerciseService;
    private final BodypartService bodypartService;

    public ExerciseManagementController(ExerciseService exerciseService,
                                        BodypartService bodypartService){
        this.exerciseService = exerciseService;
        this.bodypartService = bodypartService;
    }

    @GetMapping("/admin/dodaj-cwiczenie")
    public String addExerciseForm(Model model){
        List<BodypartDto> allBodyparts = bodypartService.findAllBodyparts();
        model.addAttribute("bodyparts", allBodyparts);
        ExerciseDto exercise = new ExerciseDto();
        model.addAttribute("exercise", exercise);
        return "admin/exercise-form";
    }



    @PostMapping("/admin/dodaj-cwiczenie")
    public String addExercise(ExerciseDto exercise, RedirectAttributes redirectAttributes) {
        exerciseService.addExercise(exercise);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Ćwiczenie %s zostało zapisane"
                        .formatted(exercise.getName()));
                return "redirect:/admin";
    }

}
