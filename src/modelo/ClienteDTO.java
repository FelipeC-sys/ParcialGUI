package modelo;

public class ClienteDTO {

    private String nombre;
    private String tipo;

    public ClienteDTO(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }
}
