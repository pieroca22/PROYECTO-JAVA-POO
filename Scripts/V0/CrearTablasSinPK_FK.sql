
--===============================
--  1. Tabla de Clientes
--===============================
CREATE TABLE Cliente (
    idCliente INT IDENTITY(1,1) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    telefono VARCHAR(9) NOT NULL,
    email VARCHAR(100) NULL,
    direccion VARCHAR(200) NOT NULL,
    fechaRegistro DATETIME NOT NULL DEFAULT GETDATE()
);

--===============================
--  2. Tabla Rol
--===============================
CREATE TABLE Rol (
	idRol INT PRIMARY KEY,
	descripcion VARCHAR(50) -- jefe de taller, encargado de produccion, personal administrativo
)

--===============================
--  3. Tabla Empleado
--===============================
CREATE TABLE Empleado (
	idEmpleado INT IDENTITY(1,1) PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	idRol INT NOT NULL
)

--===============================
--  4. Tabla de Estado
--===============================
CREATE TABLE Estado (
    idEstado INT PRIMARY KEY,
    descripcion VARCHAR(50), -- INICIO: En espera de inicio(1) / Registrado(2)
							 -- INTERMEDIO: En proceso(3) / En espera de material(4) / En acabado(5) / Completado(6)
							 -- FINAL: Entregado(7)
-- Cuando Estado = Completado (6) --> fechaFinalizacion se confirma a esa hora
	categoria VARCHAR(50)	 -- Inicial, Intermedio, Final 
);

--===============================
--  5. Tabla de Pedido
--===============================
CREATE TABLE Pedido (
    idPedido INT IDENTITY(1,1) PRIMARY KEY,
    idCliente INT NOT NULL,
    descripcion NVARCHAR(500) NOT NULL,
    fechaSolicitud DATETIME NOT NULL DEFAULT GETDATE(),
	idEstado INT DEFAULT 1,
    fechaComprometida DATETIME NOT NULL

);

--===============================
--  6. Tabla de Seguimiento Estado (Historial cuando se cambia el estado)
--===============================
CREATE TABLE SeguimientoEstado (
	idSeguimiento INT IDENTITY(1,1) PRIMARY KEY,
	idPedido INT NOT NULL,
	idEstado INT NOT NULL,
	fechaCambio DATETIME NOT NULL DEFAULT GETDATE()
);

--===============================
--  7. Tabla de Entrega
--===============================
CREATE TABLE Entrega (
    idEntrega INT IDENTITY(1,1) PRIMARY KEY,
    idPedido INT NOT NULL,
    fechaEntrega DATETIME NOT NULL DEFAULT GETDATE(),
    observaciones VARCHAR(300)
);

--===============================
--  8. Tabla de Asignacion
--===============================
CREATE TABLE Asignacion (
    idAsignacion INT IDENTITY(1,1) PRIMARY KEY,
    idPedido INT NOT NULL,
    idEmpleado INT NOT NULL, 
    fechaAsignacion DATETIME NOT NULL DEFAULT GETDATE()
);

--===============================
--  9. Tabla de Pago
--===============================
CREATE TABLE Pago (
	idPago INT IDENTITY(1,1) PRIMARY KEY,
	idPedido INT NOT NULL,
	monto DECIMAL(10,2)
)


