package com.cenfotec.grillitofeliz.domain;

import javax.persistence.*;
import java.util.List;


@Entity
public class Encargado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre, cedula, direccion, telefonoPrimario, telefonoSecundario;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ESTUDIANTE_ID", referencedColumnName = "ID")
    private Estudiante estudiantes;

    public Encargado(Long id, String nombre, String cedula, String direccion, String telefonoPrimario,
                     String telefonoSecundario, Estudiante estudiante) {
        this.id = id;
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefonoPrimario = telefonoPrimario;
        this.telefonoSecundario = telefonoSecundario;
        this.estudiantes = estudiante;
    }

    public Encargado() {
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoPrimario() {
        return telefonoPrimario;
    }

    public void setTelefonoPrimario(String telefonoPrimario) {
        this.telefonoPrimario = telefonoPrimario;
    }

    public String getTelefonoSecundario() {
        return telefonoSecundario;
    }

    public void setTelefonoSecundario(String telefonoSecundario) {
        this.telefonoSecundario = telefonoSecundario;
    }

    public Estudiante getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        StringBuilder value = new StringBuilder("ClienteEntry(");
        value.append("Id: ");
        value.append(id);
        value.append(",Nombre: ");
        value.append(nombre);
        value.append(",Cédula: ");
        value.append(cedula);
        value.append(",Dirección: ");
        value.append(direccion);
        value.append(",Teléfono Primario: ");
        value.append(telefonoPrimario);
        value.append(",Teléfono Secundario: ");
        value.append(telefonoSecundario);
        value.append(")");
        return value.toString();
    }

}
