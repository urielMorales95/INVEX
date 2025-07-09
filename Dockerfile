# Etapa 1: Compilar el proyecto con Maven y JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Crear carpeta de trabajo
WORKDIR /app

# Copiar todos los archivos al contenedor
COPY . .

# Compilar y empaquetar el proyecto (sin pruebas)
RUN mvn clean package -DskipTests

# Etapa 2: Crear imagen final con solo el JAR
FROM eclipse-temurin:17-jre-alpine

# Crear carpeta de trabajo para la app
WORKDIR /app

# Copiar el JAR desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Comando para ejecutar el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
