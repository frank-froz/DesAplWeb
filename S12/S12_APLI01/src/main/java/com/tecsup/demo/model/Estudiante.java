package com.tecsup.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String carrera;

    // Getters y Setters

    public Long getId() {return id;
    }

    public void setId(Long id) {this.id = id;
    }

    public String getNombre() {return nombre;
    }

    public void setNombre(String nombre) {this.nombre = nombre;
    }

    public String getApellido() {return apellido;
    }

    public void setApellido(String apellido) {this.apellido = apellido;
    }

    public String getCorreo() {return correo;
    }

    public void setCorreo(String correo) {this.correo = correo;
    }

    public String getCarrera() {return carrera;
    }

    public void setCarrera(String carrera) {this.carrera = carrera;
    }
}
