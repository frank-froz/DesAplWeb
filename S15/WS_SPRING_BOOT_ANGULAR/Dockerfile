# 1️⃣ Etapa de build
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2️⃣ Etapa de ejecución
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV PORT 8080
EXPOSE ${PORT}

ENTRYPOINT ["java", "-jar", "app.jar"]
