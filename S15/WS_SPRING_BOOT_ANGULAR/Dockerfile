# Imagen base de Java
FROM eclipse-temurin:17-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el jar al contenedor
COPY target/*.jar app.jar

# Puerto que usará Render (usa variable de entorno PORT)
ENV PORT 8080
EXPOSE ${PORT}

# Comando para ejecutar el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
