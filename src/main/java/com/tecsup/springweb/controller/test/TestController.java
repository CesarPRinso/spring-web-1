package com.tecsup.springweb.controller.test;

import com.tecsup.springweb.model.Programa;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/", "pruebas", "test"})
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("tituloAnterior", "Hola TECSUP");
        model.addAttribute("tituloAnterior", "Bienvenidos al curso de String Framework");

        return "test/index";
    }

    @RequestMapping("index2")
    public ModelAndView indexMV() {

        Map<String, Object> retorno = new HashMap<String, Object>();
        retorno.put("tituloAnterior", "Hola TECSUP");
        retorno.put("tituloAnterior", "Bienvenidos al curso de String Framework");

        return new ModelAndView("test/index", retorno);
    }

    @ModelAttribute
    public void info(Model model) {
        model.addAttribute("titulo", "Hola TECSUP");
        model.addAttribute("contenido", "Bienvenidos al curso de String Framework");
    }

    @RequestMapping("informacion")
    public String alternativo() {
        return "test/informacion";
    }

    @RequestMapping(value = {"info", "prueba"}, method = RequestMethod.POST)
    public String pruebas() {
        return "test/pruebas";
    }

    /* PUNTO 6*/
    @RequestMapping("parametros")
    public String parametros(String nom, String ape, Model model) {

        model.addAttribute("nombreApellido", nom + " " + ape);
        return "test/parametros";
    }

    @RequestMapping("parametros2")
    public String parametrosDos(@RequestParam("nom") String nom,
            @RequestParam("ape") String ape, Model model) {

        model.addAttribute("nombreApellido", nom + " " + ape);
        return "test/parametros";
    }

    @RequestMapping("binding")
    public String binding(Programa programa, Model model) {
        model.addAttribute("programa", programa);
        return "test/binding";
    }
    
    @ResponseBody
    @RequestMapping("ajax")
    public String ajax(Programa programa, Model model) {
        return programa.getNombre() + " "+ programa.getCodigo() ;
    }
    
     @ResponseBody
    @RequestMapping("ajax2")
    public Programa ajax2(Programa programa, Model model) {
        return programa;
    }
    
    
    

}
