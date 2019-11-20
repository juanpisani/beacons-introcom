FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8069

ARG JAR_FILE=./target/discovery-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} discovery-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/discovery-service-0.0.1-SNAPSHOT.jar"]


