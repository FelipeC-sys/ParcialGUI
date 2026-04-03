package modelo;

public class CompraDTO {

    private int cantidad;
    private double valorUnitario;

    public CompraDTO(int cantidad, double valorUnitario) {
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }
}
