package com.usuarios.apiusuarios.usuarios.model;

public class Usuario {

    private int id;
    private String nombre;
    private String email;
    private String contraseña;
    private int edad;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String email, String contraseña, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.edad = edad;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public int getEdad() {
        return edad;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
