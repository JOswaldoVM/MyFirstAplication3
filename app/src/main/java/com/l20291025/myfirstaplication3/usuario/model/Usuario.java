package com.l20291025.myfirstaplication3.usuario.model;

public class Usuario {
    private String usuario;
    private String passs;
    private String nombre;
    private int edad;
    private String email;

    public Usuario(String usuario, String passs, String nombre, int edad, String email) {
        this.usuario = usuario;
        this.passs = passs;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPasss() {
        return passs;
    }

    public void setPasss(String passs) {
        this.passs = passs;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
