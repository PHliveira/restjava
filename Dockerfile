# Estágio 1: Build (Compilação)
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn clean package -DskipTests

# Estágio 2: Execução (Runtime)
# Usa uma imagem menor (JRE) para a execução final
FROM eclipse-temurin:17-jre-alpine
EXPOSE 10000  # O Render usará essa porta

# Copia o JAR do estágio de build
COPY --from=build /app/target/*.jar app.jar
ENV PORT 10000 # Define a porta como uma variável de ambiente

# Inicia a aplicação. O JAR precisa estar configurado para usar a variável $PORT.
ENTRYPOINT ["java", "-jar", "app.jar"]