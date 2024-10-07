



# Truekepop

Truekepop es una aplicación web de trueque, inspirada en plataformas de compra y venta , pero enfocada en el intercambio de bienes queremos quitarle el valor al dinero y añadírselo a la necesidad. Los usuarios pueden registrarse, iniciar sesión, enviar mensajes directos para intercambiar objetos y hacer "match" con otros usuarios para llevar a cabo un trueque. La aplicación se enfoca en la comunidad de intercambio, ofreciendo una experiencia única de comunicación.


##README Frony.

https://github.com/JuliaParra/Proyecto-personal-TrueKePop-Front/blob/main/TrueKePop/README.md


## Características

-   Registro e inicio de sesión de usuarios utilizando correo electrónico.
-   Roles de usuario: 'USER' y 'ADMIN'.
-   Publicación y visualización de truekes (intercambios) en diferentes categorías, como 'urgentes', 'directos', 'escucho ofertas', 'novedades' y 'favoritos'.
-   Sistema de 'likes' para que los usuarios puedan añadir truekes a su lista de favoritos.
-   Dashboard de administrador para la gestión de usuarios y publicaciones.
-   Intercambio de mensajes directos entre usuarios.
-   Sistema de filtrado y búsqueda de truekes por categorías.
-   Integración con Firebase para la subida de imágenes.

## Tecnologías utilizadas

-   **Frontend:** Vue 3, Axios, Bootstrap.
-   **Backend:** Spring Boot, Java, Spring Security (para autenticación y roles).
-   **Base de datos:** MySQL y H2 (para pruebas locales).
-   **Contenedorización:** Docker y Docker Compose.
-   **Otras herramientas:** Firebase para gestión de imágenes.

## Estructura del proyecto

El proyecto sigue una estructura desacoplada en el backend, con las siguientes carpetas:

-   `security`: Contiene la configuración de seguridad de la aplicación.
-   `config`: Configuraciones generales de la aplicación.
-   `controller`: Controladores para manejar las peticiones del frontend.
-   `jpa`: Implementaciones de JPA para la gestión de datos.
-   `authservices`: Servicios de autenticación.
-   `user`: Gestión de las entidades relacionadas con los usuarios.
-   `repositories`: Repositorios para la interacción con la base de datos.

## Configuración

### Backend

1.  Clona el repositorio e instala las dependencias de Maven.
    
2.  Configura las conexiones a la base de datos MySQL o H2 en los archivos `application.properties`.
    
3.  Para ejecutar el proyecto en Docker, asegúrate de tener Docker y Docker Compose instalados y ejecuta:
    
    bash
    
    Copiar código
    
    `docker-compose up --build` 
    

### Frontend

1.  Navega a la carpeta del frontend e instala las dependencias con:
    
    bash
    
    Copiar código
    
    `npm install` 
    
2.  Inicia el servidor de desarrollo con:
    
    bash
    
    Copiar código
    
    `npm run dev` 
    

### Base de datos

-   La base de datos se configura para trabajar tanto con MySQL como con H2 para facilitar las pruebas. Para insertar datos iniciales, utiliza el archivo `data.sql`.

## Uso

-   Los usuarios pueden registrarse, iniciar sesión y ver los truekes publicados.
-   El administrador tiene permisos adicionales para gestionar usuarios y publicaciones a través del dashboard.
-   Los truekes pueden ser filtrados por categorías para una mejor experiencia de usuario.

## Seguridad

-   La aplicación utiliza Spring Security para la autenticación de usuarios, utilizando cookies en lugar de tokens.
-   Las contraseñas se encriptan utilizando `BCryptPasswordEncoder`.

## Próximas mejoras

-   Añadir más funcionalidades a la sección de favoritos.
-   Mejorar el sistema de búsqueda y filtrado de truekes.
-   Implementar notificaciones para los usuarios.

## Contribución

Las contribuciones al proyecto son bienvenidas. Para contribuir, sigue los siguientes pasos:

1.  Haz un fork del repositorio.
2.  Crea una rama con una nueva funcionalidad (`git checkout -b feature/nueva-funcionalidad`).
3.  Realiza los cambios y haz un commit (`git commit -m 'Añadir nueva funcionalidad'`).
4.  Sube los cambios a tu repositorio (`git push origin feature/nueva-funcionalidad`).
5.  Crea un Pull Request para revisar los cambios.

## Contacto

Para más información o soporte, contacta con el equipo de desarrollo.
