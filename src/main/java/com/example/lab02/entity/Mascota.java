package com.example.lab02.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mascota")
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idMascota")
    private int idMascota;

    public int getIdMascota() {return idMascota;}
    public void setIdMascota(int idMascota) {this.idMascota = idMascota;}

    @Column(name = "nombre")
    private String nombre;

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @Column(name = "especie")
    private String especie;

    public String getEspecie() {return especie;}
    public void setEspecie(String especie) {this.especie = especie;}

    @Column(name = "raza")
    private String raza;

    public String getRaza() {return raza;}
    public void setRaza(String raza) {this.raza = raza;}

    @Column(name = "edad")
    private int edad;

    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    @Column(name = "nombre_dueno")
    private String nombreDueno;

    public String getNombreDueno() {return nombreDueno;}
    public void setNombreDueno(String nombreDueno) {this.nombreDueno = nombreDueno;}

    @Column(name = "telefono")
    private String telefono;

    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    @Column(name = "estado")
    private int estado;

    public int getEstado() {return estado;}
    public void setEstado(int estado) {this.estado = estado;}

    public Mascota(){}
}
