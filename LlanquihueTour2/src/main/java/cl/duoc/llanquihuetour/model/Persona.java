package cl.duoc.llanquihuetour.model;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String rut;
    private Direccion direccion;

    public Persona(String nombre, LocalDate fechaNacimiento, String rut, Direccion direccion) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setRut(rut);
        setDireccion(direccion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El campo nombre no puede estar vacío.");
        }

        this.nombre = nombre.trim();
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        // Se valida que la fecha de nacimiento no sea nula.
        if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Fecha de nacimiento inválida");
        }

        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad(){
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        // Se comprueba que el campo no esté nulo
        if (rut == null || rut.isBlank()){
            throw new IllegalArgumentException("El campo rut no puede estar vacío.");
        }

        this.rut = rut.trim();
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
       //Comprueba que la persona tenga una dirección asignada
        if (direccion == null){
            throw new IllegalArgumentException("El campo dirección no puede estar vacío.");
        }
        this.direccion = direccion;
    }



    @Override
    public String toString() {
        return
                "\nNombre: " + nombre +
                        "\nFecha de Nacimiento: " + fechaNacimiento +
                        "\nEdad: " + getEdad() + " años" +
                        "\nRUT: " + rut +
                        "\nDireccion: " + direccion.getCalle() + " " +
                        direccion.getNumero() + ", " + direccion.getComuna() + ". Región " +
                        direccion.getRegion();


    }


    }

