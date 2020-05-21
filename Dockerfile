FROM openjdk:8-alpine

RUN mkdir -p /working && apk update
WORKDIR /working

CMD ["java", "-jar", "app.jar"]

COPY target/example-spring-boot-with-security-0.0.1-SNAPSHOT.jar app.jar