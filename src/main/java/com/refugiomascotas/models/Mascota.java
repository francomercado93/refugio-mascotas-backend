package com.refugiomascotas.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private java.lang.String nombre;

    private String tipo;

    private String descripcion;

    private String imagen;

    private Integer edad;

    public Mascota() {
    }

    public Mascota(String name, String type, String desc, String img, Integer age) {
        this.nombre = name;
        this.tipo = type;
        this.descripcion = desc;
        this.imagen = img;
        this.edad = age;
    }

    // public Mascota(String name, Tipo type, String desc, String img, Integer age) {
    //     this.nombre = name;
    //     this.tipo = type;
    //   this.descripcion = desc;
    //   this.imagen = img;
    //   this.edad = age;
    // }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public java.lang.String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }

    public java.lang.String getImagen() {
        return imagen;
    }

    public void setImagen(java.lang.String imagen) {
        this.imagen = imagen;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Map<String, Object> makeDTO() {
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("_id", this.getId());
        dto.put("nombre", this.getNombre());
        dto.put("edad", this.getEdad());
        dto.put("tipo", this.getTipo());
        dto.put("imagen", this.getImagen());
        dto.put("descripcion", this.getDescripcion());
        return dto;
    }
}
