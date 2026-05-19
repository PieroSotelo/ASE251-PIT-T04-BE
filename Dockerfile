# ---- Build stage ----
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copia solo el pom primero para cachear dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia el código fuente y compila
COPY src ./src
RUN mvn clean package -DskipTests -B

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Crea usuario no-root por seguridad
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

COPY --from=build /app/target/*.jar app.jar

# Cambia propietario del jar
RUN chown appuser:appgroup app.jar

USER appuser

EXPOSE 8080

# Permite que Spring Boot reciba señales de parada correctamente
ENTRYPOINT ["java", "-jar", "app.jar"]
