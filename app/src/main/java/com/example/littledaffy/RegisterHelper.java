package com.example.littledaffy;

public class RegisterHelper {
    String nombres, apellidos, correo, contraseña,id;
    int tipou;
    public RegisterHelper() {

    }

    public RegisterHelper(String nombres, String apellidos, String correo, String contra,String id,int tipou) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contraseña = contra;
        this.tipou = tipou;
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getTipou() {
        return tipou;
    }

    public void setTipou(int tipou) {
        this.tipou = tipou;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
