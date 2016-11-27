package brands.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping(path = "/")
    public String index() {
        return "dashboard";
    }
}
