package pe.isil.moduloseguridad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.isil.moduloseguridad.service.UserService;

@Controller
public class IndexController {


    @Qualifier("userServiceLocal")
    @Autowired
    private UserService userService;


    @GetMapping({"/", "/home", "/index"})
    public String index(Model model) {


        model.addAttribute("lstusers", userService.getUsers());
        return "index";
    }

}