FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8071

ARG JAR_FILE=./target/beacon-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} beacon-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/beacon-service-0.0.1-SNAPSHOT.jar"]

