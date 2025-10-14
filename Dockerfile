
FROM maven:3.8.5-openjdk-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src /app/src
RUN mvn clean package -DskipTests


FROM eclipse-temurin:17-jre-alpine
EXPOSE 10000


COPY --from=build /app/target/*.jar app.jar
ENV PORT 10000


ENTRYPOINT ["java", "-jar", "app.jar"]