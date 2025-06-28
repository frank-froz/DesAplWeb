package com.tecsup.demo.controller;


import com.tecsup.demo.model.Categoria;
import com.tecsup.demo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public String crearCategoria(@RequestBody Categoria categoria) {
        categoriaRepository.save(categoria);
        return "Categoria guardada con exito";
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria obtenerCategoria(@PathVariable Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public String actualizarCategoria(@PathVariable Long id,
                                      @RequestBody Categoria categoriaActualizada) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            Categoria c = categoria.get();
            c.setNombre(categoriaActualizada.getNombre());
            categoriaRepository.save(c);
            return "Categoria actualizada con exito";
        } else {
            return "Categoria no encontrada";
        }
    }

    @DeleteMapping("/{id}")
    public String eliminarCategoria(@PathVariable Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return "Categoria eliminada con exito";
        } else {
            return "Categoria no encontrada";
        }
    }
}
