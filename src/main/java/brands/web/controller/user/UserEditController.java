package brands.web.controller.user;

import brands.core.entity.Gender;
import brands.core.entity.User;
import brands.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users/edit/{id}")
public class UserEditController {

    public static final String TARGET_ENTITY_KEY = "user";
    public static final String FORM_MODEL_KEY = "form";

    public static final String ERRORS_MODEL_KEYS = BindingResult.MODEL_KEY_PREFIX + FORM_MODEL_KEY;

    @Autowired
    private UserService userService;

    @ModelAttribute(TARGET_ENTITY_KEY)
    public User setupUser(@PathVariable Long id) {
        return userService.searchUser(id);
    }

    @ModelAttribute("genders")
    public Gender[] setupGenders() {
        return Gender.values();
    }

    @GetMapping
    public String input(Model model) {
        User user = (User) model.asMap().get(TARGET_ENTITY_KEY);
        UserEditForm form = (UserEditForm) model.asMap().get(FORM_MODEL_KEY);
        form = Optional.ofNullable(form).orElse(new UserEditForm(user));

        model.addAttribute(FORM_MODEL_KEY, form);
        model.addAttribute(TARGET_ENTITY_KEY, user);
        return "user/edit";
    }

    @PostMapping
    public String edit(
            @PathVariable Long id,
            @Validated @ModelAttribute(name = FORM_MODEL_KEY) UserEditForm form,
            BindingResult errors,
            RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(FORM_MODEL_KEY, form);
        redirectAttributes.addFlashAttribute(ERRORS_MODEL_KEYS, errors);
        if (errors.hasErrors()) {
            return "redirect:/users/edit/{id}?error";
        }

        User updatedUser = userService.edit(form.toUserEditRequest(), id);
        redirectAttributes.getFlashAttributes().clear();
        redirectAttributes.addFlashAttribute("updatedUser", updatedUser);

        return "redirect:/users";
    }
}
