package com.tecsup.demo.repository;

import com.tecsup.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> id(Long id);
}
