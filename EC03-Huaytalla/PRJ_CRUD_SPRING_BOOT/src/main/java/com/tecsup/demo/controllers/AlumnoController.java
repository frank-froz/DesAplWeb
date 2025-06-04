package com.tecsup.demo.controllers;

import com.tecsup.demo.domain.entities.Alumno;
import com.tecsup.demo.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import java.util.Map;

@Controller
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @RequestMapping(value = "/listarAlumno", method = RequestMethod.GET)
    public String listarAlumno(Model model) {
        model.addAttribute("alumnos", alumnoService.listar());
        return "listarAlumno";
    }

    @RequestMapping(value = "/formAlumno")
    public String crear(Map<String, Object> model) {

        Alumno alumno = new Alumno();
        model.put("alumno", alumno);
        return "formAlumno";
    }

    @RequestMapping(value = "/formAlumno", method = RequestMethod.POST)
    public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus status) {
        if(result.hasErrors()) {
            return "formAlumno";
        }

        alumnoService.grabar(alumno);
        status.setComplete();
        return "redirect:/listarAlumno";
    }

    // Form para editar
    @RequestMapping(value="/formAlumno/{id}")
    public String editar(@PathVariable(value="id") Integer id, Map<String, Object> model) {

        Alumno alumno = null;

        if(id > 0) {
            alumno = alumnoService.buscar(id);
        } else {
            return "redirect:/listarAlumno";
        }
        model.put("alumno", alumno);
        return "formAlumno";
    }

    // Eliminar
    @RequestMapping(value="/eliminarAlumno/{id}")
    public String eliminar(@PathVariable(value="id") Integer id) {

        if(id > 0) {
            alumnoService.eliminar(id);
        }
        return "redirect:/listarAlumno";
    }

    // Ver
    @RequestMapping(value="/verAlumno")
    public String ver(Model model) {
        model.addAttribute("alumnos", alumnoService.listar());
        model.addAttribute("titulo", "Lista de alumnos");

        return "alumno/verAlumno";
    }
}
