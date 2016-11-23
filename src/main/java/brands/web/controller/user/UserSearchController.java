package brands.web.controller.user;

import brands.core.entity.User;
import brands.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserSearchController {

    public static final String FORM_MODEL_KEY = "form";

    @Autowired
    private UserService userService;

    @GetMapping
    public String search(Model model) {
        List<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "user/search";
    }
}
