USE [master]
GO
/****** Object:  Database [Mecafab]    Script Date: 7/06/2025 21:28:27 ******/
CREATE DATABASE [Mecafab]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Mecafab', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Mecafab.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Mecafab_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Mecafab_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Mecafab] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Mecafab].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Mecafab] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Mecafab] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Mecafab] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Mecafab] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Mecafab] SET ARITHABORT OFF 
GO
ALTER DATABASE [Mecafab] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Mecafab] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Mecafab] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Mecafab] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Mecafab] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Mecafab] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Mecafab] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Mecafab] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Mecafab] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Mecafab] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Mecafab] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Mecafab] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Mecafab] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Mecafab] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Mecafab] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Mecafab] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Mecafab] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Mecafab] SET RECOVERY FULL 
GO
ALTER DATABASE [Mecafab] SET  MULTI_USER 
GO
ALTER DATABASE [Mecafab] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Mecafab] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Mecafab] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Mecafab] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Mecafab] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Mecafab] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Mecafab', N'ON'
GO
ALTER DATABASE [Mecafab] SET QUERY_STORE = ON
GO
ALTER DATABASE [Mecafab] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Mecafab]
GO
/****** Object:  Table [dbo].[Asignacion]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Asignacion](
	[idAsignacion] [int] IDENTITY(1,1) NOT NULL,
	[idPedido] [int] NOT NULL,
	[idEmpleado] [int] NOT NULL,
	[fechaAsignacion] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idAsignacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[idCliente] [int] IDENTITY(1,1) NOT NULL,
	[codigoCliente] [varchar](10) NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[apellido] [nvarchar](50) NOT NULL,
	[telefono] [varchar](9) NOT NULL,
	[email] [nvarchar](100) NULL,
	[direccion] [nvarchar](200) NULL,
	[fechaRegistro] [datetime] NOT NULL,
 CONSTRAINT [PK__Cliente__885457EE54FA61CA] PRIMARY KEY CLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Empleado]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Empleado](
	[idEmpleado] [int] IDENTITY(1,1) NOT NULL,
	[codigoEmpleado] [varchar](10) NULL,
	[nombre] [nvarchar](50) NOT NULL,
	[apellido] [nvarchar](50) NOT NULL,
	[dni] [char](10) NULL,
	[telefono] [varchar](9) NULL,
	[email] [nvarchar](50) NULL,
	[idRol] [int] NOT NULL,
 CONSTRAINT [PK__Empleado__5295297C38DAE8B6] PRIMARY KEY CLUSTERED 
(
	[idEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Entrega]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Entrega](
	[idEntrega] [int] IDENTITY(1,1) NOT NULL,
	[idPedido] [int] NOT NULL,
	[fechaEntrega] [datetime] NOT NULL,
	[observaciones] [varchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[idEntrega] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Estado]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Estado](
	[idEstado] [int] NOT NULL,
	[descripcion] [varchar](50) NULL,
	[categoria] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idEstado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pago]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pago](
	[idPago] [int] IDENTITY(1,1) NOT NULL,
	[codigoPago] [varchar](12) NULL,
	[idPedido] [int] NOT NULL,
	[monto] [decimal](10, 2) NULL,
 CONSTRAINT [PK__Pago__BD2295ADEA23FF4B] PRIMARY KEY CLUSTERED 
(
	[idPago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pedido]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pedido](
	[idPedido] [int] IDENTITY(1,1) NOT NULL,
	[codigoPedido] [varchar](12) NULL,
	[idCliente] [int] NOT NULL,
	[descripcion] [nvarchar](500) NOT NULL,
	[fechaSolicitud] [datetime] NOT NULL,
	[idEstado] [int] NOT NULL,
	[fechaComprometida] [date] NOT NULL,
 CONSTRAINT [PK__Pedido__A9F619B7BC588F03] PRIMARY KEY CLUSTERED 
(
	[idPedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rol]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rol](
	[idRol] [int] NOT NULL,
	[descripcion] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[idRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SeguimientoEstado]    Script Date: 7/06/2025 21:28:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SeguimientoEstado](
	[idSeguimiento] [int] IDENTITY(1,1) NOT NULL,
	[idPedido] [int] NOT NULL,
	[idEstado] [int] NOT NULL,
	[fechaCambio] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[idSeguimiento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Cliente] ON 

INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (1, N'CL-0000001', N'María', N'García', N'912345678', N'maria.garcia@uni.edu', N'Av. Lima 100', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (2, N'CL-0000002', N'José', N'Martínez', N'923456789', N'jose.martinez@uni.edu', N'Jr. Arequipa 200', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (3, N'CL-0000003', N'Ana', N'López', N'934567890', N'ana.lopez@uni.edu', N'Av. La Marina 300', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (4, N'CL-0000004', N'Luis', N'Rodríguez', N'945678901', N'luis.rodriguez@uni.edu', N'Av. Bolívar 400', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (5, N'CL-0000005', N'Carmen', N'Fernández', N'956789012', N'carmen.fernandez@uni.edu', N'Jr. Junín 500', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (6, N'CL-0000006', N'Pedro', N'Sánchez', N'967890123', N'pedro.sanchez@uni.edu', N'Av. Tacna 600', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (7, N'CL-0000007', N'Laura', N'Díaz', N'978901234', N'laura.diaz@uni.edu', N'Jr. Ica 700', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (8, N'CL-0000008', N'David', N'Torres', N'989012345', N'david.torres@uni.edu', N'Av. Tacna 800', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (9, N'CL-0000009', N'Elena', N'Cruz', N'990123456', N'elena.cruz@uni.edu', N'Jr. Ayacucho 900', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
INSERT [dbo].[Cliente] ([idCliente], [codigoCliente], [nombre], [apellido], [telefono], [email], [direccion], [fechaRegistro]) VALUES (10, N'CL-0000010', N'Miguel', N'Castillo', N'901234567', N'miguel.castillo@uni.edu', N'Av. Grau 1000', CAST(N'2025-06-07T00:53:40.670' AS DateTime))
SET IDENTITY_INSERT [dbo].[Cliente] OFF
GO
INSERT [dbo].[Estado] ([idEstado], [descripcion], [categoria]) VALUES (1, N'Registrado', N'Inicial')
INSERT [dbo].[Estado] ([idEstado], [descripcion], [categoria]) VALUES (2, N'En producción', N'Intermedio')
INSERT [dbo].[Estado] ([idEstado], [descripcion], [categoria]) VALUES (3, N'En espera de material', N'Intermedio')
INSERT [dbo].[Estado] ([idEstado], [descripcion], [categoria]) VALUES (4, N'En acabado', N'Intermedio')
INSERT [dbo].[Estado] ([idEstado], [descripcion], [categoria]) VALUES (5, N'Completado', N'Intermedio')
INSERT [dbo].[Estado] ([idEstado], [descripcion], [categoria]) VALUES (6, N'Entregado', N'Final')
GO
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (1, N'Jefe de taller')
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (2, N'Encargado de produccion')
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (3, N'Personal administrativo')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_Empleado_CodigoEmpleado]    Script Date: 7/06/2025 21:28:27 ******/
ALTER TABLE [dbo].[Empleado] ADD  CONSTRAINT [UQ_Empleado_CodigoEmpleado] UNIQUE NONCLUSTERED 
(
	[codigoEmpleado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_Pago_CodigoPago]    Script Date: 7/06/2025 21:28:27 ******/
ALTER TABLE [dbo].[Pago] ADD  CONSTRAINT [UQ_Pago_CodigoPago] UNIQUE NONCLUSTERED 
(
	[codigoPago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ_Pedido_CodigoPedido]    Script Date: 7/06/2025 21:28:27 ******/
ALTER TABLE [dbo].[Pedido] ADD  CONSTRAINT [UQ_Pedido_CodigoPedido] UNIQUE NONCLUSTERED 
(
	[codigoPedido] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Asignacion] ADD  DEFAULT (getdate()) FOR [fechaAsignacion]
GO
ALTER TABLE [dbo].[Cliente] ADD  CONSTRAINT [DF__Cliente__fechaRe__37A5467C]  DEFAULT (getdate()) FOR [fechaRegistro]
GO
ALTER TABLE [dbo].[Entrega] ADD  DEFAULT (getdate()) FOR [fechaEntrega]
GO
ALTER TABLE [dbo].[Pedido] ADD  CONSTRAINT [DF__Pedido__fechaSol__4222D4EF]  DEFAULT (getdate()) FOR [fechaSolicitud]
GO
ALTER TABLE [dbo].[Pedido] ADD  CONSTRAINT [DF__Pedido__idEstado__4316F928]  DEFAULT ((1)) FOR [idEstado]
GO
ALTER TABLE [dbo].[SeguimientoEstado] ADD  DEFAULT (getdate()) FOR [fechaCambio]
GO
ALTER TABLE [dbo].[Asignacion]  WITH NOCHECK ADD  CONSTRAINT [FK_Asignacion_Empleado] FOREIGN KEY([idEmpleado])
REFERENCES [dbo].[Empleado] ([idEmpleado])
GO
ALTER TABLE [dbo].[Asignacion] CHECK CONSTRAINT [FK_Asignacion_Empleado]
GO
ALTER TABLE [dbo].[Asignacion]  WITH NOCHECK ADD  CONSTRAINT [FK_Asignacion_Pedido] FOREIGN KEY([idPedido])
REFERENCES [dbo].[Pedido] ([idPedido])
GO
ALTER TABLE [dbo].[Asignacion] CHECK CONSTRAINT [FK_Asignacion_Pedido]
GO
ALTER TABLE [dbo].[Empleado]  WITH NOCHECK ADD  CONSTRAINT [FK_Empleado_Rol] FOREIGN KEY([idRol])
REFERENCES [dbo].[Rol] ([idRol])
GO
ALTER TABLE [dbo].[Empleado] CHECK CONSTRAINT [FK_Empleado_Rol]
GO
ALTER TABLE [dbo].[Entrega]  WITH NOCHECK ADD  CONSTRAINT [FK_Entrega_Pedido] FOREIGN KEY([idPedido])
REFERENCES [dbo].[Pedido] ([idPedido])
GO
ALTER TABLE [dbo].[Entrega] CHECK CONSTRAINT [FK_Entrega_Pedido]
GO
ALTER TABLE [dbo].[Pago]  WITH NOCHECK ADD  CONSTRAINT [FK_Pago_Pedido] FOREIGN KEY([idPedido])
REFERENCES [dbo].[Pedido] ([idPedido])
GO
ALTER TABLE [dbo].[Pago] CHECK CONSTRAINT [FK_Pago_Pedido]
GO
ALTER TABLE [dbo].[Pedido]  WITH NOCHECK ADD  CONSTRAINT [FK_Pedido_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([idCliente])
GO
ALTER TABLE [dbo].[Pedido] CHECK CONSTRAINT [FK_Pedido_Cliente]
GO
ALTER TABLE [dbo].[Pedido]  WITH NOCHECK ADD  CONSTRAINT [FK_Pedido_Estado] FOREIGN KEY([idEstado])
REFERENCES [dbo].[Estado] ([idEstado])
GO
ALTER TABLE [dbo].[Pedido] CHECK CONSTRAINT [FK_Pedido_Estado]
GO
ALTER TABLE [dbo].[SeguimientoEstado]  WITH NOCHECK ADD  CONSTRAINT [FK_SeguimientoEstado_Estado] FOREIGN KEY([idEstado])
REFERENCES [dbo].[Estado] ([idEstado])
GO
ALTER TABLE [dbo].[SeguimientoEstado] CHECK CONSTRAINT [FK_SeguimientoEstado_Estado]
GO
ALTER TABLE [dbo].[SeguimientoEstado]  WITH NOCHECK ADD  CONSTRAINT [FK_SeguimientoEstado_Pedido] FOREIGN KEY([idPedido])
REFERENCES [dbo].[Pedido] ([idPedido])
GO
ALTER TABLE [dbo].[SeguimientoEstado] CHECK CONSTRAINT [FK_SeguimientoEstado_Pedido]
GO
USE [master]
GO
ALTER DATABASE [Mecafab] SET  READ_WRITE 
GO
