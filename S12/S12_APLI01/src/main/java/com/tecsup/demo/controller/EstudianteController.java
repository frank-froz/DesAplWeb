package com.tecsup.demo.controller;

import com.tecsup.demo.model.Estudiante;
import com.tecsup.demo.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @RequestMapping("/")
    public String inicio() {
        return "redirect:/estudiantes/lista";
    }

    @GetMapping
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.listarEstudiantes());
        return "estudiantes/lista";
    }

    @GetMapping("/crear")
    public String crearEstudianteForm(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "estudiantes/crear";
    }

    @PostMapping("/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.registrarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, Model model) {
        model.addAttribute("estudiante", estudianteService.obtenerEstudiante(id));
        return "estudiantes/editar";
    }

    @PostMapping("/actualizar")
    public String actualizarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.registrarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
