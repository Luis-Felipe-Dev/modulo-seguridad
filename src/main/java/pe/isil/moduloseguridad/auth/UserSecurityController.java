package pe.isil.moduloseguridad.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.transaction.Transactional;

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
            return "ValidationResponse";
        } else {
            return "redirect:/user/";
        }
    }

    @GetMapping("/resetpassword")
    public String resetPassword() {
        return "security/reset-password";
    }

    @Transactional
    @PostMapping("resetpassword")
    public String resetPassword(@ModelAttribute(name = "resetpassworduser") UserSecurity userSecurity, Model model) {

        UserSecurity user = userSecurityService.findUserSecurityEmail(userSecurity.getEmail());

        if (user != null) {
            user.setPassword(user.getPassword() != null ? userSecurity.getPassword() : user.getPassword());

            model.addAttribute("resp", "Hola " + user.getName() + ", su contraseña fue restablecida satisfactoriamente!!!");

        } else {
            model.addAttribute("resp", "Usuario no existe!!!");
        }
        return "reset-passw-message";
    }
}
