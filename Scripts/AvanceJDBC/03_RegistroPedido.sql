
SELECT * FROM Cliente

SELECT * FROM Empleado

SELECT * FROM Estado

SELECT * FROM Pedido

-- REGISTRO DE PEDIDOS
INSERT INTO 
Pedido (idCliente, descripcion, fechaSolicitud, idEstado, fechaComprometida)
VALUES (?,?,?,?,?)

-- CONSULTAR PEDIDO
SELECT pe.idPedido, 
	   CONCAT(cl.nombre,' ',cl.apellido) AS cliente, 
	   pe.descripcion, pe.fechaSolicitud, pe.fechaComprometida,  
	   es.descripcion AS estado
FROM Pedido pe 
JOIN Cliente cl ON cl.idCliente = pe.idCliente
JOIN Estado es ON es.idEstado = pe.idEstado 
WHERE cl.nombre COLLATE Latin1_General_CI_AI LIKE '9' OR 
	  cl.apellido COLLATE Latin1_General_CI_AI LIKE '9' OR 
      cl.telefono LIKE '%9%'