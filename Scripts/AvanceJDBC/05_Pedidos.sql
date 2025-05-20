
SELECT * FROM Pedido
SELECT * FROM Estado
SELECT * FROM Empleado
SELECT * FROM Asignacion

-- MOSTRAR LOS PEDIDOS EN idEstado = 1 (En espera de inicio) 
SELECT pe.idPedido, 
	   pe.descripcion AS descripcionPedido, 
       pe.fechaSolicitud, pe.fechaComprometida
       pe.idCliente, 
       CONCAT(cl.nombre,' ',cl.apellido) AS cliente, 
       cl.telefono , pe.idEstado, 
       est.descripcion AS descripcionEstado 
FROM Pedido pe 
JOIN Cliente cl ON pe.idCliente = cl.idCliente
JOIN Estado est ON pe.idEstado = est.idEstado
WHERE pe.idEstado = 1 
ORDER BY pe.fechaSolicitud 
