package com.agenda.contactos;

import java.util.ArrayList;

public class Agenda {
    private int maxContactos;
    private ArrayList<Contacto> agenda;


    public Agenda() {
    }

    public Agenda(int maxContactos) {
        this.maxContactos = maxContactos;
        this.agenda = new ArrayList<>();
    }

    public void agendaLlena(){
        if(agenda.size() == maxContactos){
            System.out.println("La agenda esta llena. No tiene espacio disponible.");
        } else {
            System.out.println("Aún tiene espacio en la agenda.");
        }
    }

    public void espacioLibre(){
        int espacio = maxContactos - agenda.size();
        System.out.println("Puede agregar" + espacio + " contacto(s).");
    }
}
