FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8073

ARG JAR_FILE=./target/messages-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} messages-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/messages-service-0.0.1-SNAPSHOT.jar"]

