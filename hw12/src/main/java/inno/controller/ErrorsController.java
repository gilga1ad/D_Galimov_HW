package inno.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.nio.file.AccessDeniedException;

@Controller
public class ErrorsController {

    @RequestMapping("/error")
    public String errorTest() throws AccessDeniedException {
        if (true) {
            throw new AccessDeniedException("Access denied");
        }
        return "redirect:/posts";
    }

}
