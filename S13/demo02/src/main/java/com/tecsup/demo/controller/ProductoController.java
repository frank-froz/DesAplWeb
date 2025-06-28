package com.tecsup.demo.controller;

import com.tecsup.demo.model.Categoria;
import com.tecsup.demo.model.Producto;
import com.tecsup.demo.repository.CategoriaRepository;
import com.tecsup.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public String crearProducto(@RequestBody Producto producto) {
        if(producto.getNombre() == null ||
                !categoriaRepository.existsById(producto.getCategoria().getId())) {
            throw new IllegalArgumentException("El nombre del categoria no existe");
        }
        productoRepository.save(producto);
        return "Producto creado";
    }

    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public String actualizarProducto(@PathVariable Long id,
                                     @RequestBody Producto productoActualizado) {
        return productoRepository.findById(id).map(producto -> {
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());

            if (productoActualizado.getCategoria() != null) {
                Optional<Categoria> cat =
                        categoriaRepository.findById(productoActualizado.getCategoria().getId());
                cat.ifPresent(producto::setCategoria);
            }

            productoRepository.save(producto);
            return "Producto modificado";
        }).orElse("No se encontro el producto");
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return "Producto eliminado";
        } else {
            return "No se encontro el producto";
        }
    }
}
