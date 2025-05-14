
SELECT * FROM Empleado
SELECT * FROM Cliente

-- Cliente
SELECT * FROM Cliente
WHERE nombre COLLATE Latin1_General_CI_AI LIKE '%a%' OR 
	  apellido COLLATE Latin1_General_CI_AI LIKE '%d%'

SELECT * FROM Cliente
WHERE nombre COLLATE Latin1_General_CI_AI LIKE '%p%' OR 
	  apellido COLLATE Latin1_General_CI_AI LIKE '%e%' OR 
	  telefono LIKE '%91%' OR 
	  email LIKE '%j%' OR 
	  direccion COLLATE Latin1_General_CI_AI LIKE '%e%'

-- Empleado (METODO SUBCONSULTA)
SELECT * FROM Empleado em
WHERE nombre COLLATE Latin1_General_CI_AI LIKE '%z%' OR 
	  apellido COLLATE Latin1_General_CI_AI LIKE '%z%' OR 
	  -- LLamando Subconsulta para buscar tambien por el Rol del Empleado
	  (SELECT descripcion FROM Rol rl WHERE rl.idRol = em.idRol) LIKE '%e%'

-- Empleado (METODO JOIN) MEJOR
SELECT em.*, rl.descripcion FROM Empleado em
JOIN Rol rl ON rl.idRol = em.idRol
WHERE em.nombre COLLATE Latin1_General_CI_AI LIKE '%z%' OR 
	  em.apellido COLLATE Latin1_General_CI_AI LIKE '%z%' OR 
	  rl.descripcion COLLATE Latin1_General_CI_AI LIKE '%z%'
