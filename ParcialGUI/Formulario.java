public class Formulario {

    public static Usuario crearUsuario(String nombre, String apellido, String edad,
            String telefono, String tipo) {

        return new Usuario(
                nombre,
                apellido,
                Integer.parseInt(edad),
                telefono,
                tipo);
    }

    public static Compra crearCompra(String producto, String valor, String cantidad) {

        return new Compra(
                producto,
                Double.parseDouble(valor),
                Integer.parseInt(cantidad));
    }
}