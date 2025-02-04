package com.agenda.contactos;

import java.util.ArrayList;
import java.util.HashMap;

public class Contacto {
    private String nombre;
    private String apellido;
    private String numero;

    private static Integer cantidadMaxima = 10;


    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
    }

    /**
     * Metodo creado para crear una key unica del contacto formada
     * por la concatenacion del nombre y apellido en minuscula
     */
    public String getKey() {
        return nombre.toLowerCase() + apellido.toLowerCase();
    }

    public boolean existeContacto(HashMap<String, Contacto> listaDeContactos) {
        return listaDeContactos.containsKey(this.getKey());
    }

    public void listarContactos() {
        System.out.println(nombre + " " + apellido + " - " + numero);
    }

    /**
     * Metodo creado para llevar a cabo proceso de Agregar
     * un contacto con sus validaciones. El this como tal dentro del metodo esta
     * haciendo referencia al objeto contacto
     */
    public boolean añadirContacto(
            HashMap<String, Contacto> listaDeContactos,
            ArrayList<Contacto> agenda
    ) {
        if (listaDeContactos.size() >= cantidadMaxima) {
            System.out.println(" ");
            System.out.println("Lo siento, la agenda está llena. Te recomiendo borrar algún contacto.");
            System.out.println(" ");
            return false;
        } else if (this.nombre.isEmpty() || this.apellido.isEmpty()) {
            System.out.println(" ");
            System.out.println("El nombre y el apellido son campos requeridos.");
            System.out.println(" ");
            return false;
        } else if (this.existeContacto(listaDeContactos)) {
            System.out.println(" ");
            System.out.println("El contacto ya existe en tu agenda.");
            System.out.println(" ");
            return false;
        }

        listaDeContactos.put(this.getKey(), this);
        agenda.add(this);
        return true;
    }

    public void buscarContacto(String nombre) {

    }

    public void eliminarContacto(Contacto c) {

    }

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {

    }

    public void agendaLlena() {

    }

    public void espaciosLibres() {

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

