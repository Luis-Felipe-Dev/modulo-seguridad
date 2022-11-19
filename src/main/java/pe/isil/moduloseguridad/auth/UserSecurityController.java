package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserSecurityController {

    @Autowired
    private UserSecurityService userSecurityService;

    @GetMapping({"/", "/index", "/login"})
    public String login() {
        return "security/login";
    }

    @GetMapping("/adduserauth")
    public String addUser() {
        return "security/register";
    }

    @PostMapping("/adduserauth")
    public String addUser(@ModelAttribute(name = "authuser") UserSecurity userSecurity, Model model) {
        UserSecurity user = userSecurityService.addUserSecurity(userSecurity);

        return "redirect:/login";
    }

    @PostMapping("login")
    public String login(@ModelAttribute(name = "authuser") UserSecurity userSecurity, Model model) {

        UserSecurity user = userSecurityService.findUserSecurity(userSecurity.getEmail(), userSecurity.getPassword());

        if (user == null) {
            model.addAttribute("resp", "Credenciales incorrectas o usuario no existe");
        } else {
            model.addAttribute("resp", "BIENVENIDO " + user.getName());
        }

        return "index";

    }
}
