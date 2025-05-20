
-- Cambiamos este campo porque no necesitamos la hora exacta
-- Cuando se le asigne un empleado, obligatoriamente el empleado debe colocar la fecha comprometida
ALTER TABLE Pedido
ALTER COLUMN fechaComprometida DATE NULL
GO

