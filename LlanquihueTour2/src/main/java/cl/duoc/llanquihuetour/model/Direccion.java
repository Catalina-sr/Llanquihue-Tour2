package cl.duoc.llanquihuetour.model;

public class Direccion {
    private String calle;
    private int numero;
    private String comuna;
    private String region;

    public Direccion(String calle, int numero, String comuna, String region) {
        setCalle(calle);
        setNumero(numero);
        setComuna(comuna);
        setRegion(region);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        if(calle == null || calle.isBlank()) {
            throw new IllegalArgumentException("El campo Calle no puede estar vacío.");
        }
        this.calle = calle.trim();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero <= 0) {
            throw new IllegalArgumentException("El número debe ser mayor a 0.");
        }

        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        if(comuna == null || comuna.isBlank()) {
            throw new IllegalArgumentException("El campo Comuna no puede estar vacío.");
        }

        this.comuna = comuna.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        if(region == null || region.isBlank()) {
            throw new IllegalArgumentException("El campo Región no puede estar vacío.");
        }
        this.region = region.trim();
    }

    @Override
    public String toString() {
        return
                "Calle: " + calle +
                        ", Número: " + numero +
                        ", Comuna: " + comuna +
                        ", Región: " + region;

    }
}
