package blog.controllers;

import blog.forms.LoginForm;
import blog.services.NotificationService;
import blog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {
    private final UserService userService;
    private NotificationService notifyService;

    public LoginController(UserService userService, NotificationService notifyService) {
        this.userService = userService;
        this.notifyService = notifyService;
    }

    @RequestMapping("/users/login")
    public String login(LoginForm loginForm) {
        return "users/login";
    }
    @RequestMapping(value = "users/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/login";
        }
        if (!userService.authenticate(
                loginForm.getUsername(), loginForm.getPassword())) {
            notifyService.addErrorMessage("Invalid login!");
            return "users/login";
        }
        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}
