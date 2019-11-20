FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8069

ARG JAR_FILE=./target/proxy-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} proxy-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/proxy-service-0.0.1-SNAPSHOT.jar"]

