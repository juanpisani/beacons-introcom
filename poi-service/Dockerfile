FROM openjdk:8-jdk-alpine

VOLUME /tmp

EXPOSE 8072

ARG JAR_FILE=./target/poi-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} poi-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/poi-service-0.0.1-SNAPSHOT.jar"]

