package com.tecsup.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_orden_c;
    private Date fecha_emision;
    private String situacion;
    private BigDecimal total;
    private String nro_factura_prov;

    @ManyToOne
    @JoinColumn(name = "cod_lab")
    @JsonBackReference
    private Laboratorio laboratorio;

    // Getters y Setters
    public Long getNro_orden_c() {
        return nro_orden_c;
    }

    public void setNro_orden_c(Long nro_orden_c) {this.nro_orden_c = nro_orden_c;}

    public Date getFecha_emision() {return fecha_emision;}

    public void setFecha_emision(Date fecha_emision) {this.fecha_emision = fecha_emision;}

    public String getSituacion() {return situacion;}

    public void setSituacion(String situacion) {this.situacion = situacion;}

    public BigDecimal getTotal() {return total;}

    public void setTotal(BigDecimal total) {this.total = total;}

    public String getNro_factura_prov() {return nro_factura_prov;}

    public void setNro_factura_prov(String nro_factura_prov) {this.nro_factura_prov = nro_factura_prov;}

    public Laboratorio getLaboratorio() {return laboratorio;}

    public void setLaboratorio(Laboratorio laboratorio) {this.laboratorio = laboratorio;}
}

