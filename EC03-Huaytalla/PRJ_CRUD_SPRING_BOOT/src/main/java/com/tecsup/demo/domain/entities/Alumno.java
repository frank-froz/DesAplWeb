package com.tecsup.demo.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

@Entity
@Table(name = "alumnos")
public class Alumno implements AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column
    @NotEmpty(message = "El nombre no puede estar vacío")
    private String nombres;

    @Column
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String apellidos;

    @Column(name = "fecha_nacimiento")
    @Past(message = "La fecha debe ser en el pasado")
    private LocalDate fechanacimiento;

    @Column
    @NotEmpty(message = "El sexo no puede estar vacío")
    private String sexo;

    public Alumno() {
    }

    public Alumno(int id, String nombres, String apellidos, LocalDate fechanacimiento, String sexo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechanacimiento = fechanacimiento;
        this.sexo = sexo;
    }

    // Getters y Setters

    @Override
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }



    @Override
    public String getNombreTabla() {
        return "alumnos";
    }
    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechanacimiento=" + fechanacimiento +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
