package cl.duoc.llanquihuetour.model;

import java.time.LocalDate;

public class Empleado extends Persona {
    private int id;
    private String cargo;

    public Empleado(String nombre, LocalDate fechaNacimiento, String rut, Direccion direccion, int id, String cargo) {

        super(nombre, fechaNacimiento, rut, direccion);

        setId(id);
        setCargo(cargo);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        // Se comprueba que el ID sea mayor que cero.
        if(id <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0.");
        }
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        // Se comprueba que el campo no esté nulo
        if(cargo == null || cargo.isBlank()) {
            throw new IllegalArgumentException("El cargo no puede estar vacío.");
        }
        this.cargo = cargo.trim();
    }

    @Override
    public String toString() {
        // Se utiliza super.toString() para incorporar los datos heredados de Persona.
        return super.toString() +
                "\nID empleado: " + id +
                "\nCargo: " + cargo;

    }
}
