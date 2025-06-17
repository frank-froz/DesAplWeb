package com.tecsup.demo.controller;

import com.tecsup.demo.model.Curso;
import com.tecsup.demo.repository.CursoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    private final CursoRepository cursoRepo;

    public CursoController(CursoRepository cursoRepo) {
        this.cursoRepo = cursoRepo;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cursos", cursoRepo.findAll());
        return "cursos/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("curso", new Curso());
        return "cursos/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Curso curso) {
        cursoRepo.save(curso);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Curso curso = cursoRepo.findById(id).orElseThrow();
        model.addAttribute("curso", curso);
        return "cursos/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        cursoRepo.deleteById(id);
        return "redirect:/cursos";
    }
}
