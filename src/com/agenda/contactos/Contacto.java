package com.agenda.contactos;

import java.util.HashMap;
import java.util.Map;

public class Contacto {
    private String nombre;
    private String apellido;
    private String numero;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
    }
    public String getKey() {
        return nombre.toLowerCase()+apellido.toLowerCase();
    }

    public void añadirContacto(Contacto c){
        System.out.println("El contacto ha sido agregado");
    }

    public void existeContacto(Contacto c){

    }

    public void listarContactos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Telefono: " + numero);
    }

    public void buscarContacto(String nombre){

    }

    public void eliminarContacto(Contacto c){

    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){

    }

    public void agendaLlena(){

    }

    public void espaciosLibres(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}
