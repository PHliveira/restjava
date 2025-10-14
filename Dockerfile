
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine
EXPOSE 10000  # O Render usará essa porta


COPY --from=build /app/target/*.jar app.jar
ENV PORT 10000 # Define a porta como uma variável de ambiente


ENTRYPOINT ["java", "-jar", "app.jar"]