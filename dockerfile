FROM maven:3.8.2-jdk-11 as build-ctx

WORKDIR /socialdistancing

COPY . /socialdistancing

RUN mvn clean install -Dmaven.test.skip

FROM openjdk:11.0.12-jre-slim-buster as run-ctx

WORKDIR /api

COPY --from=build-ctx /socialdistancing/api/target/*.jar /api

RUN ls -al

ENTRYPOINT ["java", "-jar", "api-1.0-SNAPSHOT.jar"]