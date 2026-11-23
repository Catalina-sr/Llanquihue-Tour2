package cl.duoc.llanquihuetour.model;

import java.time.LocalDate;

public class GuiaTuristico extends Persona {
    private int id;
    private String idiomas;
    private String especialidad;

    public GuiaTuristico(String nombre, LocalDate fechaNacimiento, String rut, Direccion direccion, int id, String idiomas, String especialidad) {
        super(nombre, fechaNacimiento, rut, direccion);

        setId(id);
        setIdiomas(idiomas);
        setEspecialidad(especialidad);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        // Se comprueba que el ID sea mayor que cero.
        if (id <= 0){
            throw new IllegalArgumentException("El ID debe ser mayor a 0.");
        }

        this.id = id;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        // Se comprueba que el campo no esté nulo
        if (idiomas == null || idiomas.isBlank()){
            throw new IllegalArgumentException("El campo idiomas no puede estar vacío.");
        }

        this.idiomas = idiomas.trim();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        // Se comprueba que el campo no esté nulo
        if (especialidad == null || especialidad.isBlank()){
            throw new IllegalArgumentException("La especialidad no puede ser nula.");
        }
        this.especialidad = especialidad.trim();
    }

    @Override
    public String toString() {
        // Se utiliza super.toString() para incorporar los datos heredados de Persona.
        return super.toString() +
                "\nID Guía: " + id +
                "\nIdiomas: " + idiomas +
                "\nEspecialidad: " + especialidad;
    }
}
