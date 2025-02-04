package com.agenda.contactos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

            System.out.println("Selecciona una opcion del menu: ");


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
                        System.out.println("El contacto fue agregado exitosamente");
                    }
                    break;
                case 2:
                    System.out.println("Listar contactos");
                    if (agenda.isEmpty()) {
                        System.out.println("No hay contactos guardados.");
                    } else {
                        // Ordenar contactos alfabéticamente por nombre y apellido
                        Collections.sort(agenda, new Comparator<Contacto>() {
                            @Override
                            public int compare(Contacto c1, Contacto c2) {
                                int nombreCompare = c1.getNombre().compareToIgnoreCase(c2.getNombre());
                                if (nombreCompare == 0) {
                                    return c1.getApellido().compareToIgnoreCase(c2.getApellido());
                                } else {
                                    return nombreCompare;
                                }
                            }
                        });
                        for (Contacto contacto : agenda) {
                            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getNumero());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Buscar Contacto");
                    System.out.println("Ingrese el nombre del contacto");
                    nombre = scanner.next().toLowerCase();
                    System.out.println("Ingrese el apellido del contacto");
                    apellido = scanner.next().toLowerCase();
                    Contacto buscar = new Contacto(nombre, apellido, "");
                    buscar.buscarContacto(listaContactos);

                    break;
                case 4:
                    System.out.println("Eliminar contacto");
                    System.out.println("Ingrese el nombre del contacto");
                    nombre = scanner.next().toLowerCase();
                    System.out.println("Ingrese el apellido del contacto");
                    apellido = scanner.next().toLowerCase();
                    Contacto contactoEliminar = new Contacto(nombre, apellido, "");
                    contactoEliminar.eliminarContacto(listaContactos, agenda);
                    break;

                case 5:
                    System.out.println("Modificar teléfono: ");
                    System.out.println("Ingrese el nombre del contacto");
                    nombre = scanner.next().toLowerCase();
                    System.out.println("Ingrese el apellido del contacto");
                    apellido = scanner.next().toLowerCase();
                    String nombreApellido = nombre + apellido;
                    Contacto contactoModificar = listaContactos.get(nombreApellido);
                    if (contactoModificar != null) {
                        System.out.println("Ingrese el nuevo número de teléfono:");
                        String nuevoNumero = scanner.next();
                        contactoModificar.setNumero(nuevoNumero);
                        System.out.println("Número actualizado correctamente.");

                    } else {
                        System.out.println("Contacto no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Espacios libres: ");
                    int maxContactos = 10;
                    if (agenda.size() == maxContactos) {
                        System.out.println("La agenda está llena. No tiene espacio disponible.");
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
        } while (opcion != 7);
    }
}