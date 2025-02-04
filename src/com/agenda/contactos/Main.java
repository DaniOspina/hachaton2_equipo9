package com.agenda.contactos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Contacto> agenda = new ArrayList<>();
        HashMap<String, Contacto> listaContactos = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {

            System.out.println("--- Agenda telefónica ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar telefono");
            System.out.println("6. Espacios libres");
            System.out.println("7. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre del contacto");
                    String nombre = scanner.next();
                    System.out.println("Ingrese el apellido del contacto");
                    String apellido = scanner.next();
                    System.out.println("Ingrese el número del contacto");
                    String numero = scanner.next();
                    Contacto contactoNuevo = new Contacto(nombre, apellido, numero);
                    if (contactoNuevo.añadirContacto(listaContactos, agenda)) {
                        System.out.println("El contacto fue Agregado exitosamente");
                    }
                    break;


                case 2:
                    System.out.println("Listar contactos");
                    if (agenda.isEmpty()){
                        System.out.println("No hay contactos guardados.");
                    }
                    else{
                        for (Contacto contacto : agenda){
                            contacto.listarContactos();
                            System.out.println(" ");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el nombre del contacto");
                    nombre = scanner.next().toLowerCase();
                    System.out.println("Ingrese el apellido del contacto");
                    apellido = scanner.next().toLowerCase();
                    String nombreApellido = (nombre + apellido);
                    Contacto contactoInfo = listaContactos.get(nombreApellido);
                    if (contactoInfo != null) {
                        System.out.println("El número de " + contactoInfo.getNombre() + " es: " + contactoInfo.getNumero());
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Eliminar contacto");
                    System.out.println("Ingrese el nombre del contacto");
                    nombre = scanner.next().toLowerCase();
                    System.out.println("Ingrese el apellido del contacto");
                    apellido = scanner.next().toLowerCase();
                    nombreApellido = (nombre + apellido);
                    Contacto contactoNombre = listaContactos.get(nombreApellido);

                    if (contactoNombre != null) {
                        agenda.remove(contactoNombre);
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("No es posible eliminar un contacto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Modificar telefono: ");
                    break;

                case 6:
                    System.out.print("Espacios libres: ");
                    int maxContactos = 10;
                    if(agenda.size() == maxContactos){
                        System.out.println("La agenda esta llena. No tiene espacio disponible.");
                    } else {
                        System.out.println("Aún tiene espacio en la agenda.");
                        int espacio = maxContactos - agenda.size();
                        System.out.println("Puede agregar " + espacio + " contacto(s).");
                    }
                    break;

                case 7:
                    System.out.println("¡¡Agenda personal cerrada!!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
    }while( opcion != 7);
}
}
