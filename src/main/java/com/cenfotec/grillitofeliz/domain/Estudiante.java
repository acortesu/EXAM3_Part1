package com.cenfotec.grillitofeliz.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre, tipoUsuario, alergias;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ENCARGADO_ID", referencedColumnName = "ID")
    private Encargado encargado;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LIBRO_ID", referencedColumnName = "ID")
    private List<Libro> libros;

    public Estudiante(Long id, String nombre, String tipoUsuario, String alergias, Encargado encargado,
                      List<Libro> libros) {
        this.id = id;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
        this.alergias = alergias;
        this.encargado = encargado;
        this.libros = libros;
    }

    public Estudiante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuaro) {
        this.tipoUsuario = tipoUsuaro;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Encargado getEncargado() {
        return encargado;
    }

    public void setEncargado(Encargado encargado) {
        this.encargado = encargado;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("ClienteEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Nombre: ");
        value.append(nombre);
        value.append(",Tipo de Plan: ");
        value.append(tipoUsuario);
        value.append(",Alergias: ");
        value.append(alergias);
        value.append(",Nombre Encargado: ");
        value.append(encargado);
        value.append(",Libros leidos: ");
        value.append(libros);
        value.append(")");
        return value.toString();
    }
}
