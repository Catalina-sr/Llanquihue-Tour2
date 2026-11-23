package cl.duoc.llanquihuetour.model;
import java.time.LocalDate;

public class Cliente extends Persona {
    private String telefono;
    private String correo;
    private String nacionalidad;
    private String contactoEmergencia;
    private String relacionContacto;

    public Cliente(String nombre, LocalDate fechaNacimiento, String rut, Direccion direccion, String telefono, String correo, String nacionalidad, String contactoEmergencia, String relacionContacto) {

        super(nombre, fechaNacimiento, rut, direccion);

        setTelefono(telefono);
        setCorreo(correo);
        setNacionalidad(nacionalidad);
        setContactoEmergencia(contactoEmergencia);
        setRelacionContacto(relacionContacto);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        // Se comprueba que el campo no esté nulo
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        this.telefono = telefono.trim();

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        // Se comprueba que el campo no esté nulo
        if (correo == null || correo.isBlank()){
            throw new IllegalArgumentException("El campo correo no puede estar vacío.");
        }
        this.correo = correo.trim();
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        // Se comprueba que el campo no esté nulo
        if (nacionalidad == null || nacionalidad.isBlank()){
            throw new IllegalArgumentException("El campo nacionalidad no puede estar vacío.");
        }

        this.nacionalidad = nacionalidad.trim();
    }

    public String getContactoEmergencia() {
        return contactoEmergencia;
    }

    public void setContactoEmergencia(String contactoEmergencia) {
        // Se comprueba que el campo no esté nulo
        if (contactoEmergencia == null || contactoEmergencia.isBlank()){
            throw new IllegalArgumentException("El campo contacto de emergencia no puede estar vacío.");
        }
        this.contactoEmergencia = contactoEmergencia.trim();
    }

    public String getRelacionContacto() {
        return relacionContacto;
    }

    public void setRelacionContacto(String relacionContacto) {
// Se comprueba que el campo no esté nulo
        if (relacionContacto == null || relacionContacto.isBlank()){
            throw new IllegalArgumentException("El campo tipo de relación de contacto no puede estar vacío.");
        }

        this.relacionContacto = relacionContacto.trim();
    }

    @Override
    public String toString() {
        // Se utiliza super.toString() para incorporar los datos heredados de Persona.
        return super.toString() +
                "\nTeléfono: " + telefono +
                "\nCorreo: " + correo +
                "\nNacionalidad: " + nacionalidad +
                "\nContacto de emergencia: " + contactoEmergencia +
                "\nTipo de Relación: " + relacionContacto;

    }
}
