package com.tecsup.springweb.controller.programa;

import com.tecsup.springweb.model.Programa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("programa")
public class ProgramaController {

    @Autowired
    ProgramaService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {

        model.addAttribute("programas", service.listPrograma());
        model.addAttribute("programa", new Programa());
        return "programa/index";
    }

    @RequestMapping("editar")
    public String editar(@RequestParam Long id, Model model) {
        
        model.addAttribute("programa", service.get(id));
        model.addAttribute("programas", service.listPrograma());
        return "programa/index";
    }
    
    @RequestMapping("guardar")
    public String guardar(Programa programa){
        
        service.save(programa);
        return "redirect:/programa";
    }

    @RequestMapping("eliminar")
    public String eliminar(Programa programa){
        
        service.delete(programa);
        return "redirect:/programa";
    }

}

