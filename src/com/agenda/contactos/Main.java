package com.agenda.contactos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Contacto> agenda = new ArrayList<>();
        Map<String, Contacto> listaContactos = new HashMap<>();
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
            System.out.println("7.Salir");

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
                    Contacto contacto1 = new Contacto(nombre, apellido, numero);
                    agenda.add(contacto1);
                    listaContactos.put(nombre, contacto1);
                    System.out.println("Contacto agregado correctamente.");
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
                    nombre = scanner.next();
                    // System.out.println("Ingrese el apellido del contacto");
                    // apellido = scanner.next();
                    Contacto contactoInfo = listaContactos.get(nombre);
                    if (contactoInfo != null) {
                        contactoInfo.listarContactos();
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Eliminar contacto");
                    System.out.println("Ingrese el nombre del contacto");
                    nombre = scanner.next();
                    Contacto contactoNombre = listaContactos.get(nombre);
                    if (contactoNombre != null) {
                        listaContactos.remove(nombre);
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Modificar telefono: ");
                    break;

                case 6:
                    System.out.print("Espacios libres: ");
                    break;

                case 7:
                    System.out.println("¡¡ Vuelve pronto !!");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
    }while( opcion != 7);
}
}
