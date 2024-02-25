# Test back castor

## Descripción
test back castor es una aplicación Spring Boot desarrollada para guardar los datos de emepleados atraves de una API REST.

## Características
- **Spring Boot 3.2.1**: Framework para facilitar la configuración y despliegue.
- **Java 17**: Versión del lenguaje de programación.
- **Postgresql**: Base de datos relacional para almacenar los resultados de las operaciones.
- **Swagger UI**: Interfaz de usuario para interactuar fácilmente con la API.

## Metodología y Principios de Desarrollo
- **Arquitectura Hexagonal**: Utilizada para separar las preocupaciones en capas claramente definidas, facilitando la escalabilidad y mantenimiento.
- **Desarrollo Guiado por el Dominio (DDD)**: Empleando un enfoque centrado en el dominio para mejorar la claridad y la lógica del negocio.
- **Principios SOLID**: Seguidos para promover un diseño de software orientado a objetos limpio y mantenible.

## Requisitos
- Java 17

## Configuración y Ejecución
### Configuración Local
1. Clonar el repositorio.
2. Ejecutar el proyecto utilizando el comando Gradle:
   ```shell
   ./gradlew bootRun

## Uso de la API
La aplicación expone dos endpoints principales:
1. **POST /api/v1/employee**: Guardar empleado.
   - **Cuerpo de la petición**: JSON con los campos de empleado.
   - **Respuesta**: JSON con el resultado.
2. **GET /api/v1/employee**: Recupera todos los empleados.

La documentación detallada de la API y los esquemas de solicitud y respuesta están disponibles a través de la interfaz de [Swagger](http://localhost:8080/api/v1/swagger-ui/index.html#/).

## Pruebas
Las pruebas unitarias se pueden ejecutar mediante el comando:
1. *Ejecuón de pruebas:*
   ```shell
   ./gradlew test
./gradlew test


## NOTA

1. *cree primero la base datos CastorEmployees:
   ```shell
   CREATE DATABASE "CastorEmployees"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

2  * luego de que cree la base datos CastorEmployees ejecute el programa y 
     el creeara automaticamente las tablas con sus relacciones.
    
3  *Luego ejecute este script para alimentar la tabla posiciones:*
   ```shell
    INSERT INTO public."position"
   (id, "name")
   VALUES(nextval('position_id_seq'::regclass), 'Scrum Master');
   INSERT INTO public."position"
   (id, "name")
   VALUES(nextval('position_id_seq'::regclass), 'Desarrollador');
   INSERT INTO public."position"
   (id, "name")
   VALUES(nextval('position_id_seq'::regclass), 'QA');
   INSERT INTO public."position"
   (id, "name")
   VALUES(nextval('position_id_seq'::regclass), 'PO');