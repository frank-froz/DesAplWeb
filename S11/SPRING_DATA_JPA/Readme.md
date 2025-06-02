# 🏥 Proyecto Farmacia - CRUD con Spring Boot, JPA y MySQL

Este proyecto implementa una API REST básica para la gestión de laboratorios y órdenes de compra usando Spring Boot, JPA y una base de datos MySQL.

## 📁 Estructura del Proyecto

- `Laboratorio`: entidad que representa los proveedores farmacéuticos.
- `OrdenCompra`: entidad relacionada que representa las compras realizadas a los laboratorios.

## 🧰 Tecnologías Usadas

- Java 17+
- Spring Boot 3+
- Spring Data JPA
- MySQL
- Maven
- Postman (para pruebas)

## 🛠️ Requisitos Previos

- Tener MySQL instalado y en ejecución.
- Crear la base de datos ejecutando:

```
CREATE DATABASE bd_Farmacia;
```

## 🔧 Configuración

En el archivo `src/main/resources/application.properties`, configura tu conexión:

```
spring.datasource.url=jdbc:mysql://localhost:3306/bd_Farmacia
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🚀 Ejecución del Proyecto
Clona el repositorio:

```
git clone https://github.com/frank-froz/DesAplWeb/new/main/S11/SPRING_DATA_JPA
```

## 📡 Endpoints Disponibles

Laboratorios

- `GET /api/laboratorios` → Listar todos

- `POST /api/laboratorios` → Crear nuevo

- `PUT /api/laboratorios/{id}` → Actualizar

- `DELETE /api/laboratorios/{id}` → Eliminar

Órdenes de Compra

- `GET /api/ordenes` → Listar todos

- `POST /api/ordenes` → Crear nuevo

- `PUT /api/ordenes/{id}` → Actualizar

- `DELETE /api/ordenes/{id}` → Eliminar

## 🧪 Pruebas con Postman
Puedes importar la colección de pruebas Postman desde el archivo postman_collection.json incluido en el repositorio (si lo subes).

## 📝 Notas

Las pruebas fueron exitosas en Postman.

El despliegue no se realizó por falta de configuración en un servidor cloud, pero se documentó el procedimiento.

## 📌 Autor
Nombre: Franklin Huaytalla

GitHub: frank-froz
