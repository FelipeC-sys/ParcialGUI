package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.ClienteDTO;
import modelo.CompraDTO;

public class ClienteDAO {

    public void guardarCompra(ClienteDTO cliente, CompraDTO compra,
                              double total, double descuento, double pagoFinal) {

        try {
            Connection con = ConexionBD.getConnection();

            String sql = "INSERT INTO cliente_compra "
                    + "(nombre, tipo, cantidad, valor_unitario, total, descuento, pago_final) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getTipo());
            ps.setInt(3, compra.getCantidad());
            ps.setDouble(4, compra.getValorUnitario());
            ps.setDouble(5, total);
            ps.setDouble(6, descuento);
            ps.setDouble(7, pagoFinal);

            ps.executeUpdate();

            System.out.println("Guardado en BD");

        } catch (Exception e) {
            System.out.println("Error al guardar: " + e);
        }
    }
}