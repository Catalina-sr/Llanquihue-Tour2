package cl.duoc.llanquihuetour.ui;

import cl.duoc.llanquihuetour.model.*;
import cl.duoc.llanquihuetour.data.GestorPersonas;


import java.time.LocalDate;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {

            GestorPersonas gestor = new GestorPersonas();
            //Carga personas desde el archivo CSV
            int cantidad = gestor.cargarDesdeCSV();
            //Muestra cantidad de personas cargadas
            System.out.println("Personas cargadas: " + cantidad);
            System.out.println("\n✦════════ EMPLEADOS ════════✦");
            for (Persona persona : gestor.buscarPorTipo("EMPLEADO")) {
                System.out.println(persona);
            }

            System.out.println("\n╔════════════════════╗");
            System.out.println("       CLIENTES");
            System.out.println("╚════════════════════╝");
            for (Persona persona : gestor.buscarPorTipo("CLIENTE")) {
                System.out.println(persona);

            }

            System.out.println("\n════════ GUÍAS TURÍSTICOS ════════");
            for (Persona persona : gestor.buscarPorTipo("GUIA TURISTICO")) {
                System.out.println(persona);
            }

            System.out.println("\n━━━━━━━━ OPERADORES ━━━━━━━━");
            for (Persona persona : gestor.buscarPorTipo("OPERADOR")) {
                System.out.println(persona);

            }

            //Buscar personas por nombre
            System.out.println("\n✦════════ BÚSQUEDA POR NOMBRE ════════✦");
            for (Persona persona : gestor.buscarPorNombre("SOTO")){
                System.out.println(persona);
            }

            //Muestra la cantidad total de personas registradas
            System.out.println("\nTotal de personas registradas: " + gestor.contarPersonas());

            //Eliminar a una persona
            Persona persona = gestor.buscarPorNombre("Catalina").get(0);
            gestor.eliminar(persona);

            System.out.println("\n" + persona.getNombre() + " ha sido eliminada.");
            //Muestra total de eprsonas actualizado
            System.out.println("\nActualización personas registradas: " + gestor.contarPersonas());

            //Agregar une empleado nuevo
            Empleado nuevo = new Empleado("Pedro González Rojas", LocalDate.of(1998,5,12), "19.458.786-6",
                    new Direccion("Los Mañios", 380, "Frutillar", "Los Lagos"), 9, "Asistente");

                    gestor.agregar(nuevo);
                    System.out.println("\n" + nuevo.getNombre() + " ha sido agregado.");
                    System.out.println("\nTotal de personas registradas: " + gestor.contarPersonas());

            Persona antigua = gestor.buscarPorNombre("Francisca").get(0);
            Empleado reemplazo = new Empleado("María González González", LocalDate.of(1997,8,15), "18.785.984-0",
                    new Direccion("Los Robles", 250, "Puerto Varas","Los Lagos"), 10, "Administrativa");

            gestor.reemplazar(antigua,reemplazo);
            System.out.println("\n" + antigua.getNombre() + " ha sido reemplazada por " + reemplazo.getNombre());

        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());


        }
    }
}












