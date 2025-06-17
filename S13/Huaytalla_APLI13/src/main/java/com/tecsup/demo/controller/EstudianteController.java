package com.tecsup.demo.controller;

import com.tecsup.demo.model.Curso;
import com.tecsup.demo.model.Estudiante;
import com.tecsup.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private CursoRepository cursoRepo;

    @GetMapping("/nuevo")
    public String nuevoEstudiante(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        model.addAttribute("listaCursos", cursoRepo.findAll());
        return "estudiantes/formulario";
    }

    @GetMapping("/editar/{id}")
    public String editarEstudiante(@PathVariable Long id, Model model) {
        Estudiante est = estudianteRepo.findById(id).orElseThrow();
        model.addAttribute("estudiante", est);
        model.addAttribute("listaCursos", cursoRepo.findAll());
        return "estudiantes/formulario";
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudiantes", estudianteRepo.findAll());
        return "estudiantes/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        estudianteRepo.deleteById(id);
        return "redirect:/estudiantes";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Estudiante estudiante, @RequestParam List<Long> cursosIds) {
        Set<Curso> cursos = new HashSet<>(cursoRepo.findAllById(cursosIds));
        estudiante.setCursos(cursos);
        estudianteRepo.save(estudiante);
        return "redirect:/estudiantes";
    }



}
