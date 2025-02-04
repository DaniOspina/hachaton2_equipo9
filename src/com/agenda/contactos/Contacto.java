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

    public String buscarContacto(HashMap<String, Contacto> listaContactos) {
        Contacto contactoInfo = listaContactos.get(this.getKey());
        if (contactoInfo != null) {
            String resultado = "El número de " + this.nombre + " es: " + contactoInfo.getNumero();
            System.out.println(resultado);
            return resultado;
        } else {
            String mensaje = "Contacto no encontrado.";
            System.out.println(mensaje);
            return mensaje;
        }
    }

    public boolean eliminarContacto(HashMap<String, Contacto> listaContactos, ArrayList<Contacto> agenda) {
        Contacto contactoEncontrado = listaContactos.get(this.getKey());
        if (contactoEncontrado != null) {
            agenda.remove(contactoEncontrado);
            listaContactos.remove(this.getKey());
            System.out.println("Contacto eliminado.");
            return true;
        } else {
            System.out.println("No es posible eliminar un contacto no encontrado.");
            return false;
        }
    }



    public String modificarTelefono(HashMap<String, Contacto> listaContactos, String nuevoNumero) {
        Contacto contactoEncontrado = listaContactos.get(this.getKey());
        if (contactoEncontrado != null) {
            contactoEncontrado.setNumero(nuevoNumero);
            return  "Número actualizado correctamente";
        } else {
            return "Contacto no encontrado.";
        }
    }

    public String agendaLlena(ArrayList<Contacto> agenda){
        if(agenda.size() == cantidadMaxima){
            return "La agenda esta llena. No tiene espacio disponible.";
        } else {
            return "Aún tiene espacio en la agenda.";
        }
    }

    public String espacioLibre(ArrayList<Contacto> agenda){
        int espacio = cantidadMaxima - agenda.size();
        return "Puede agregar" + espacio + " contacto(s).";
    }


    public String getNombre() {

        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}

