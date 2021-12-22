FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN  --mount=type=cache,target=/root/.m2  mvn -f /home/app/pom.xml clean package

FROM openjdk:8-jdk-alpine 
COPY --from=build /home/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
