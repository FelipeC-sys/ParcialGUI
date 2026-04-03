create database TiendaElect;
use TiendaElect;
CREATE TABLE cliente_compra (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50),
    cantidad INT,
    valor_unitario DOUBLE,
    total DOUBLE,
    descuento DOUBLE,
    pago_final DOUBLE
);