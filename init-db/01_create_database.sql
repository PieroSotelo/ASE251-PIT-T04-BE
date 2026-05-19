-- Script de inicialización: crea la base de datos si no existe
-- Se ejecuta automáticamente al primer arranque del contenedor SQL Server

IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'AgroExportDB')
BEGIN
    CREATE DATABASE AgroExportDB;
    PRINT 'Base de datos AgroExportDB creada correctamente.';
END
ELSE
BEGIN
    PRINT 'La base de datos AgroExportDB ya existe.';
END
GO
