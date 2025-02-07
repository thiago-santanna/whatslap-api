# Etapa de build
FROM maven:3.9.0-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa de runtime
FROM openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

# Configuração do MySQL
FROM mysql:8.0
ENV MYSQL_DATABASE=notificacao
ENV MYSQL_ROOT_PASSWORD=102057
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=password
EXPOSE 3306