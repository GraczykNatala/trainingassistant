package pl.graczyk.trainingassistant.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.graczyk.trainingassistant.domain.user.UserService;
import pl.graczyk.trainingassistant.domain.user.dto.UserRegistrationDto;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/rejestracja")
    public String registrationForm(Model model){
        UserRegistrationDto userRegistration = new UserRegistrationDto();
        model.addAttribute("user", userRegistration);
        return "registration-form";
    }
    @PostMapping("/rejestracja")
    public String register(UserRegistrationDto userRegistration){
        userService.registerUserWithDefautRole(userRegistration);
        return "redirect:/";
    }
}
