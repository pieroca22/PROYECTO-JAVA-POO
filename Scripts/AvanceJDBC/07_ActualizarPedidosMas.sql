-- Actualizar Pedido
--Listar Pedidos TODOS
SELECT pe.idPedido, 
       pe.descripcion AS descripcionPedido, 
       pe.fechaSolicitud, pe.fechaComprometida, 
       pe.idCliente, 
       CONCAT(cl.nombre,' ',cl.apellido) AS cliente, 
       pe.idEstado, 
       est.descripcion AS descripcionEstado 
FROM Pedido pe 
JOIN Cliente cl ON pe.idCliente = cl.idCliente
JOIN Estado est ON pe.idEstado = est.idEstado
ORDER BY pe.fechaSolicitud DESC, pe.idEstado ASC

-- Listar Estados
SELECT idEstado, descripcion, categoria FROM Estado

-- CodigoCliente a UNIQUE
ALTER TABLE Cliente
ADD CONSTRAINT UQ_Cliente_CodigoCliente UNIQUE (codigoCliente)
-- codigoEmpleado a UNIQUE
ALTER TABLE Empleado
ADD CONSTRAINT UQ_Empleado_CodigoEmpleado UNIQUE (codigoEmpleado)
-- codigoPedido a UNIQUE
ALTER TABLE Pedido
ADD CONSTRAINT UQ_Pedido_CodigoPedido UNIQUE (codigoPedido)
-- codigoPago a UNIQUE
ALTER TABLE Pago
ADD CONSTRAINT UQ_Pago_CodigoPago UNIQUE (codigoPago)