package org.sergei.cleanup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Sergei Visotsky
 */
@Controller
@RequestMapping("/")
public class WelcomeController {
    @GetMapping
    @ResponseBody
    public String welcome() {
        return "Folder cleanup";
    }
}
