package controlador;

import modelo.*;
import logica.Procesos;
import dao.ClienteDAO;

public class Coordinador {

    private Procesos procesos = new Procesos();
    private ClienteDAO dao = new ClienteDAO();

    public String realizarCompra(ClienteDTO cliente, CompraDTO compra) {

        double total = procesos.calcularTotal(
                compra.getValorUnitario(),
                compra.getCantidad());

        double descuento = procesos.calcularDescuento(
                cliente.getTipo(),
                total);

        double pagoFinal = procesos.calcularPagoFinal(total, descuento);

        dao.guardarCompra(cliente, compra, total, descuento, pagoFinal);

        return "Pago final: " + pagoFinal;
    }
}
