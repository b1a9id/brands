package brands.web.controller.user;

import brands.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users/delete/{id}")
public class UserDeleteController {

    @Autowired
    UserService userService;

    @DeleteMapping
    public String delete(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {
        String deletedUserName = userService.deleteUser(id);
        deletedUserName = userService.searchUser(id) == null ? deletedUserName : null;
        redirectAttributes.addFlashAttribute("deletedUser", deletedUserName);
        return "redirect:/users";
    }
}
