# Proyecto Evahuaytalla

## Descripción

Evahuaytalla es una aplicación que gestiona laboratorios y órdenes de compra. Permite registrar laboratorios, asociados a órdenes de compra, y gestionar la información básica de contacto y operativa de cada laboratorio.

El sistema incluye las siguientes funcionalidades:

- Gestión de laboratorios: Registrar información básica de los laboratorios como razón social, dirección, teléfono, correo electrónico y contacto.

- Gestión de órdenes de compra: Vincular órdenes de compra a laboratorios, registrando detalles como fecha de emisión, número de factura, situación y total.

Este proyecto está desarrollado con Spring Boot para el backend.

## Tecnologías

- Spring Boot (para el backend)

- MySQL (base de datos)

- Maven (gestor de dependencias)

## Requisitos

JDK 17 o superior

MySQL (o cualquier otra base de datos relacional compatible con JPA)

Maven (para la construcción del proyecto)

## Instalación

1. Clonar el repositorio

    ```bash
    
    git clone https://github.com/frank-froz/DesAplWeb
    ```

2. Configuración de la base de datos
   
    Asegúrate de tener MySQL (o una base de datos compatible) instalada y configurada. Crea una base de datos llamada evahuaytalla y configura las credenciales en el archivo application.properties de la siguiente manera:
  
    properties
    
      ```
      spring.datasource.url=jdbc:mysql://localhost:3306/evahuaytalla
      spring.datasource.username=root
      spring.datasource.password=tu_contraseña
      spring.jpa.hibernate.ddl-auto=update
      ```

3. Compilar el proyecto
  Utiliza Maven para compilar el proyecto:

      ```
      mvn clean install
      ```

4. Ejecutar la aplicación
   Para ejecutar el proyecto, usa el siguiente comando:

    ```
    mvn spring-boot:run
    ```


La aplicación estará disponible en `http://localhost:8080`.

## 🧪 ENDPOINTS CRUD


A continuación se muestran algunos ejemplos de cómo usar los endpoints REST de la aplicación para interactuar con los laboratorios y órdenes de compra.

1. LABORATORIO
   
   - ✅ Crear laboratorio
     
     **POST** `http://localhost:8080/api/laboratorios`
    
      Body (JSON):
      
      ```json
      
      {
        "razonSocial": "LabQuimico SAC",
        "direccion": "Av. Ciencia 123",
        "telefono": "987654321",
        "email": "contacto@labquimico.com",
        "contacto": "Dra. Ana Pérez"
      }
      ```
    
   - Obtener todos los laboratorios}
     
       **GET** `http://localhost:8080/api/laboratorios`
     
   - Obtener laboratorio por ID
     
       **GET** `http://localhost:8080/api/laboratorios/1`
     
   - Actualizar laboratorio
     
       **PUT** `http://localhost:8080/api/laboratorios/1`
     
       Body (JSON):
  
      ```json
      
      {
        "razonSocial": "LabQuimico Modificado",
        "direccion": "Av. Innovación 456",
        "telefono": "987654321",
        "email": "nuevo@labquimico.com",
        "contacto": "Ing. Juan Ruiz"
      }
      ```
   - Eliminar laboratorio

     **DELETE** `http://localhost:8080/api/laboratorios/1`
  
3. 🧾 ENDPOINTS CRUD – NroOrdenC
   - ✅ Crear orden vinculada a un laboratorio
     
     **POST** `http://localhost:8080/api/ordenes`
  
      Body (JSON):
      
      ```json
      
      {
        "fechaEmision": "2025-05-17",
        "situacion": "Emitido",
        "total": 1200.50,
        "nroFacturaProv": "FAC12345",
        "laboratorio": {
          "codLab": 1
        }
      }
      ```
   - Obtener todas las órdenes
     
       **GET** `http://localhost:8080/api/ordenes`
     
   - Obtener orden por ID
     
       **GET** `http://localhost:8080/api/ordenes/1`
     
   - Actualizar orden
     
       **PUT** `http://localhost:8080/api/ordenes/1`
     
       Body (JSON):

      ```json
          
          {
            "fechaEmision": "2025-05-18",
            "situacion": "Pagado",
            "total": 1300.00,
            "nroFacturaProv": "FAC12345-EDIT",
            "laboratorio": {
              "codLab": 1
            }
          }
      ```
   - Eliminar orden
     
       **DELETE** `http://localhost:8080/api/ordenes/1`



    Respuestas de error comunes
    400 Bad Request: Cuando los datos enviados no son válidos.
    
    404 Not Found: Cuando no se encuentra el recurso (por ejemplo, si el id de un laboratorio o una orden no existe).
    
    500 Internal Server Error: Si ocurre un error inesperado en el servidor.


## Licencia
Este proyecto está bajo la Licencia MIT. Ver el archivo LICENSE para más detalles.
