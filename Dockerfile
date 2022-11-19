#
## Build stage
FROM maven:3.8.4-jdk-11 AS build-stage
WORKDIR /source
ARG JAR_FILE=target/*.jar
COPY . .
RUN mvn -q clean package -DskipTests
RUN cp ${JAR_FILE} app.jar

#
## Release stage
FROM openjdk:8-jdk-alpine
WORKDIR /
COPY --from=build-stage /source/app.jar app.jar
COPY docker-entrypoint.sh .

EXPOSE 8080

CMD []
ENTRYPOINT ["./docker-entrypoint.sh"]