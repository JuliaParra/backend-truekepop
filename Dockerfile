# Usar la imagen oficial de MySQL
FROM mysql:8.0

# Exponer el puerto MySQL
EXPOSE 3306

# Establecer las variables de entorno para la contraseña de root y la base de datos inicial
ENV MYSQL_ROOT_PASSWORD=rootpassword
ENV MYSQL_DATABASE=trueke_db

# Copiar el archivo de configuración si lo tienes
# COPY ./my.cnf /etc/mysql/my.cnf

# El contenedor arrancará automáticamente MySQL

