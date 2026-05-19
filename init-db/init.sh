#!/bin/bash
# Espera a que SQL Server esté listo y luego ejecuta los scripts de inicialización

echo "Esperando que SQL Server inicie..."
sleep 20

for i in {1..10}; do
    /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P "Admin1234!" -Q "SELECT 1" -No -C > /dev/null 2>&1
    if [ $? -eq 0 ]; then
        echo "SQL Server listo. Ejecutando scripts de inicialización..."
        for f in /docker-entrypoint-initdb.d/*.sql; do
            echo "Ejecutando $f..."
            /opt/mssql-tools18/bin/sqlcmd -S localhost -U sa -P "Admin1234!" -i "$f" -No -C
        done
        echo "Inicialización completada."
        break
    fi
    echo "Intento $i: SQL Server aún no está listo, esperando 5s..."
    sleep 5
done
