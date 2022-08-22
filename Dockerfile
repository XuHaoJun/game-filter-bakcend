FROM openjdk:8-jdk-alpine
WORKDIR /
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY docker-entrypoint.sh .
CMD []
ENTRYPOINT ["./docker-entrypoint.sh"]