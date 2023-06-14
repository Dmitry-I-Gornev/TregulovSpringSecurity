package tregulov.spring.security.components.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppSecurityController {
    @GetMapping(path = "/")
    public String pageForAllEmployees() {
        return "view-for-all-employees";
    }

    @GetMapping(path = "/hr_info")
    public String pageForOnlyHR() {
        return "view-for-hr";
    }

    @GetMapping(path = "/managers_info")
    public String pageForOnlyManagers() {
        return "view-for-managers";
    }
}
