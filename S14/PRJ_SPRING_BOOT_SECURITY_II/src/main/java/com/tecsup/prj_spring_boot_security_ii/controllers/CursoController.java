package com.tecsup.prj_spring_boot_security_ii.controllers;


import com.tecsup.prj_spring_boot_security_ii.domain.entities.Curso;
import com.tecsup.prj_spring_boot_security_ii.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("curso")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @RequestMapping(value = {"/listar"}, method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de cursos");
        model.addAttribute("cursos", cursoService.listar());
        return "listar";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = {"/form"})
    public String crear(Map<String, Object> model) {
        Curso curso = new Curso();
        model.put("curso", curso);
        return "form";
    }

    @RequestMapping(value = "/form/{id}")
    public String editar(@PathVariable(value = "id") Integer id, Map<String, Object> model) {
        Curso curso = null;

        if (id > 0) {
            curso = cursoService.buscar(id);
        } else {
            return "redirect:/listar";
        }

        model.put("curso", curso);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Curso curso, BindingResult result, Model model, SessionStatus status) {
        if (result.hasErrors()) {
            return "form";
        }

        cursoService.grabar(curso);
        status.setComplete();
        return "redirect:/listar";
    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Integer id) {
        if (id > 0) {
            cursoService.eliminar(id);
        }
        return "redirect:/listar";
    }

    @RequestMapping("/ver")
    public String ver(@RequestParam(required = false) String format, Model model) {
        model.addAttribute("cursos", cursoService.listar());

        if ("pdf".equals(format)) {
            return "curso/ver"; // PDF View
        } else {
            return "listar"; // Thymeleaf HTML
        }
    }

}