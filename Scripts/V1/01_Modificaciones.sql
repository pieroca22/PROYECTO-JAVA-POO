
-- REGISTROS YA PREDETERMINADOS, NO SE MODIFICAN ESTOS REGISTROS
INSERT INTO Rol (idRol, descripcion)
VALUES (1, 'Jefe de taller'), (2, 'Encargado de produccion'), (3, 'Personal administrativo')
GO

INSERT INTO Estado (idEstado, descripcion, categoria)
VALUES 
	-- Inicio
	   (1, 'En espera de inicio', 'Inicial'), (2, 'Registrado', 'Inicial'), 
	-- Intermedio
	   (3, 'En proceso', 'Intermedio'), (4, 'En espera de material', 'Intermedio'), 
	   (5, 'En acabado', 'Intermedio'), (6, 'Completado', 'Intermedio'),
	-- Final
	   (7, 'Entregado', 'Final')
GO