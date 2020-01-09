package com.refugiomascotas.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.Map;

@Entity
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long _id;

    private String nombre;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mascota_id")
    private Tipo tipo;

    private String descripcion;

    private String imagen;

    private Integer edad;

    public Mascota() {
    }

    public Mascota(String name, Tipo type, String desc, String img, Integer age) {
        this.nombre = name;
        this.tipo = type;
        this.descripcion = desc;
        this.imagen = img;
        this.edad = age;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombreTipo() {
        return this.getTipo().getNombre();
    }

    public Map<String, Object> makeDTO() {
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("_id", this.get_id());
        dto.put("nombre", this.getNombre());
        dto.put("edad", this.getEdad());
        dto.put("tipo", this.getNombreTipo());
        dto.put("imagen", this.getImagen());
        dto.put("descripcion", this.getDescripcion());
        return dto;
    }
}
