package cl.duoc.llanquihuetour.model;

import java.time.LocalDate;

public class Operador extends Persona {
    private int id;
    private String empresa;
    private String servicioOfrecido;

    public Operador(String nombre, LocalDate fechaNacimiento, String rut, Direccion direccion, int id, String empresa, String servicioOfrecido) {
        super(nombre, fechaNacimiento, rut, direccion);

        setId(id);
        setEmpresa(empresa);
        setServicioOfrecido(servicioOfrecido);
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        // Se comprueba que el campo no esté nulo
        if (empresa == null || empresa.isBlank()){
            throw new IllegalArgumentException("El campo empresa no puede estar vacío.");
        }

        this.empresa = empresa.trim();
    }

    public String getServicioOfrecido() {
        return servicioOfrecido;
    }

    public void setServicioOfrecido(String servicioOfrecido) {
        // Se comprueba que el campo no esté nulo
        if (servicioOfrecido == null || servicioOfrecido.isBlank()){
            throw new IllegalArgumentException("El campo de servicio ofrecido no puede estar vacío.");
        }

        this.servicioOfrecido = servicioOfrecido.trim();
    }

    @Override
    public String toString() {
        // Se utiliza super.toString() para incorporar los datos heredados de Persona.
        return super.toString() +
                "\nID Operador: "+ id +
                "\nEmpresa: " + empresa +
                "\nServicio Ofrecido: " + servicioOfrecido;
    }
}