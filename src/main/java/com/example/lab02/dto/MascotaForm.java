package com.example.lab02.dto;

public class MascotaForm {

    private int idMascota;
    public int getIdMascota() {return idMascota;}
    public void setIdMascota(int idMascota) {this.idMascota = idMascota;}

    private String nombre;
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    private String especie;
    public String getEspecie() {return especie;}
    public void setEspecie(String especie) {this.especie = especie;}

    private String raza;
    public String getRaza() {return raza;}
    public void setRaza(String raza) {this.raza = raza;}

    private int edad;
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}

    private String nombreDueno;
    public String getNombreDueno() {return nombreDueno;}
    public void setNombreDueno(String nombreDueno) {this.nombreDueno = nombreDueno;}

    private String telefono;
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}

    private int estado;
    public int getEstado() {return estado;}
    public void setEstado(int estado) {this.estado = estado;}

    public MascotaForm() {}
}
