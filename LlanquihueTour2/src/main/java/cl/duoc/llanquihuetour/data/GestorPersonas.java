package cl.duoc.llanquihuetour.data;

import cl.duoc.llanquihuetour.model.Cliente;
import cl.duoc.llanquihuetour.model.Direccion;
import cl.duoc.llanquihuetour.model.Empleado;
import cl.duoc.llanquihuetour.model.GuiaTuristico;
import cl.duoc.llanquihuetour.model.Operador;
import cl.duoc.llanquihuetour.model.Persona;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class GestorPersonas {

    private final List<Persona> listaPersonas = new ArrayList<>();

    public void agregar(Persona persona) {
        listaPersonas.add(persona);
    }

    public List<Persona> listar() {
        // retorna una copia de la lista completa para proteger la colección original
        return new ArrayList<>(listaPersonas);
    }

    public List<Persona> buscarPorTipo(String tipo) {
        List<Persona> encontradas = new ArrayList<>();
        for (Persona persona : listaPersonas) {
            /**
             * instanceof busca personas según su tipo, identificando la clase a la que pertenece cada objeto.
             * Así podemos filtrar el tipo que estamos buscando y agregar las coindicencias a una nueva lista.
             */
            if ((tipo.equalsIgnoreCase("EMPLEADO") && persona instanceof Empleado) ||
                    (tipo.equalsIgnoreCase("CLIENTE") && persona instanceof Cliente) ||
                    (tipo.equalsIgnoreCase("GUIA TURISTICO") && persona instanceof GuiaTuristico) ||
                    (tipo.equalsIgnoreCase("OPERADOR") && persona instanceof Operador)) {

                encontradas.add(persona);
            }
        }
        return encontradas;

    }

    /**
     * Busca personas por su nombre, permitiendo coincidencias parciales
     * y sin distinguir entre mayúsculas y minúsculas.
     */

    public List<Persona> buscarPorNombre(String nombre) {
        List<Persona> encontradas = new ArrayList<>();
        String buscado = nombre.trim().toLowerCase();
        for (Persona persona : listaPersonas) {
            if (persona.getNombre().toLowerCase().contains(buscado)) {
                encontradas.add(persona);
            }

        }
        return encontradas;
    }

    //cuenta la cantidad de personas registradas
    public int contarPersonas() {
        return listaPersonas.size();
    }

    /**
     * Revisa cada persona de la lista y comprueba
     * si es la misma persona que queremos eliminar
     */
    public boolean eliminar(Persona persona) {
        return listaPersonas.removeIf(p -> p == persona);
    }

    public boolean reemplazar(Persona antigua, Persona nueva) {
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i) == antigua) {
                listaPersonas.set(i, nueva);
                return true;
            }
        }
        return false;
    }

    /**
     * Vaciar la colección
     */
    public void limpiar() {
        listaPersonas.clear();
    }

    /**
     * Carga las personas desde el archivo CSV
     * y las agrega a la lista.
     */
    public int cargarDesdeCSV() throws IOException {
    // Limpia la lista antes de cargar nuevamente los datos para evitar que se diplique.
        listaPersonas.clear();

        int cantidadCargada = 0;

        try (InputStream archivo = GestorPersonas.class.getResourceAsStream("/personas.csv")) {

            if (archivo == null) {
                throw new IOException("No se encontró el archivo personas.csv");
            }

            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(archivo, StandardCharsets.UTF_8));

            String linea;
            String tipoActual = "";

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

            while ((linea = lector.readLine()) != null) {
                // Elimina el carácter BOM del inicio del archivo CSV, si está presente.
                linea = linea.replace("\uFEFF", "");

                if (linea.isBlank()) {
                    continue;
                }

                if (linea.equalsIgnoreCase("EMPLEADOS")) {
                    tipoActual = "EMPLEADO";
                    continue;
                }

                if (linea.equalsIgnoreCase("CLIENTES")) {
                    tipoActual = "CLIENTE";
                    continue;
                }

                if (linea.equalsIgnoreCase("GUÍAS TURÍSTICOS")) {
                    tipoActual = "GUIA TURISTICO";
                    continue;
                }

                if (linea.equalsIgnoreCase("OPERADORES")) {
                    tipoActual = "OPERADOR";
                    continue;
                }

                // Omite la fila que contiene los nombres de las columnas.
                if (linea.startsWith("Nombre;")) {
                    continue;
                }

                // Separa los datos de cada persona.
                String[] datos = linea.split(";", -1);


                // Convierte la fecha de nacimiento a LocalDate.
                LocalDate fechaNacimiento = LocalDate.parse(datos[1].trim(), formato);

                //Obtiene datos que tienen en común todas las personas
                String nombre = datos[0].trim();
                String rut = datos[2].trim();

                Direccion direccion = new Direccion(
                        datos[3].trim(),
                        Integer.parseInt(datos[4].trim()),
                        datos[5].trim(),
                        datos[6].trim()
                );

                // Se crea y agrega cada persona según su tipo
                if (tipoActual.equalsIgnoreCase("EMPLEADO")) {
                    Empleado empleado = new Empleado(
                            nombre, fechaNacimiento, rut, direccion, Integer.parseInt(datos[7].trim()), datos[8].trim());
                    agregar(empleado);
                    cantidadCargada++;

                } else if (tipoActual.equalsIgnoreCase("CLIENTE")) {
                    Cliente cliente = new Cliente(
                            nombre, fechaNacimiento, rut, direccion, datos[7].trim(), datos[8].trim(), datos[9].trim(),
                            datos[10].trim(), datos[11].trim());
                    agregar(cliente);
                    cantidadCargada++;

                } else if (tipoActual.equalsIgnoreCase("GUIA TURISTICO")) {
                    GuiaTuristico guiaTuristico = new GuiaTuristico(
                            nombre, fechaNacimiento, rut, direccion, Integer.parseInt(datos[7].trim()), datos[8].trim(), datos[9].trim());
                    agregar(guiaTuristico);
                    cantidadCargada++;

                } else if (tipoActual.equalsIgnoreCase("OPERADOR")) {
                    Operador operador = new Operador(
                            nombre, fechaNacimiento, rut, direccion, Integer.parseInt(datos[7].trim()), datos[8].trim(), datos[9].trim());
                    agregar(operador);
                    cantidadCargada++;
                }
            }
        } catch (RuntimeException e) {
            throw new IOException("El CSV contiene datos inválidos " + e.getMessage(), e);
        }

        return cantidadCargada;
    }

}