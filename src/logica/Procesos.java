package logica;

public class Procesos {

    public double calcularTotal(double valor, int cantidad) {
        return valor * cantidad;
    }

    public double calcularDescuento(String tipo, double total) {

        if (tipo.equals("A")) {
            return total * 0.10;
        } else if (tipo.equals("B")) {
            return total * 0.05;
        } else if (tipo.equals("C")) {
            return 0;
        }
        return 0;
    }

    public double calcularPagoFinal(double total, double descuento) {
        return total - descuento;
    }
}
