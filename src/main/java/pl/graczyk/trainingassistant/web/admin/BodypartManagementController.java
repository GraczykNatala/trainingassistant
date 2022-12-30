package pl.graczyk.trainingassistant.web.admin;

import jakarta.persistence.PostRemove;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.graczyk.trainingassistant.domain.bodypart.BodypartService;
import pl.graczyk.trainingassistant.domain.bodypart.dto.BodypartDto;

@Controller
public class BodypartManagementController {
    private final BodypartService bodypartService;

    public BodypartManagementController(BodypartService bodypartService) {
        this.bodypartService = bodypartService;
    }
    @GetMapping("/admin/dodaj-partie")
    public String addBodypartForm(Model model){
        BodypartDto bodypart = new BodypartDto();
        model.addAttribute("bodypart", bodypart);
        return "admin/bodypart-form";
    }
    @PostMapping("/admin/dodaj-partie")
    public String addBodypart(BodypartDto bodypart, RedirectAttributes redirectAttributes){
        bodypartService.addBodypart(bodypart);
        redirectAttributes.addFlashAttribute(
                AdminController.NOTIFICATION_ATTRIBUTE,
                "Partia %s została zapisana"
                        .formatted(bodypart.getName()));
        return"redirect:/admin";
    }
}
