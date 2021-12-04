package com.moniguar.app.citas;

public class Usuario {

    private String nombres;
    private String numeroIdentificacion;
    private String direccion;
    private String ciudad;
    private String celular;
    private String fijo;
    private String eMail;
    private String login;
    private String password;

    public Usuario() {
    }

    public Usuario(String nombres, String numeroIdentificacion, String direccion, String ciudad, String celular, String fijo, String eMail, String login, String password) {
        this.nombres = nombres;
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.celular = celular;
        this.fijo = fijo;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getFijo() {
        return fijo;
    }

    public void setFijo(String fijo) {
        this.fijo = fijo;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
