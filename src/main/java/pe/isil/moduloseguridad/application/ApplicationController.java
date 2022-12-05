package pe.isil.moduloseguridad.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.isil.moduloseguridad.user.UserService;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("listapplications", applicationService.findAll());
        return "application/index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("listusers", userService.findAll());
        return "application/register";
    }

    @PostMapping("/register")
    public String registerApplication(Application application, Model model){
        ApplicationDTO result = applicationService.addApplication(application);

        if(result.getCode().equals("200")){
            return "redirect:/application/";
        }
        else{
            model.addAttribute("resp", result.getMessage());
            return "/application/response";
        }
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") Long id, Model model) {
        model.addAttribute("listusers", userService.findAll());
        model.addAttribute("applicationToUpdate", applicationService.findApplicationById(id));
        return "application/update";
    }

    @PostMapping("/update")
    public String updateApplication(Application application, Model model){
        ApplicationDTO result = applicationService.updateApplication(application, application.getId());

        if(result.getCode().equals("200")){
            return "redirect:/application/";
        }
        else{
            model.addAttribute("resp", "Nombre de la aplicación ya está en uso, por favor probar con otro.");
            return "/application/response";
        }
    }

    @DeleteMapping("/delete")
    public String deleteApplication(@RequestParam("id") Long id){
        applicationService.deleteApplication(id);
        return "redirect:/application/";
    }
}
