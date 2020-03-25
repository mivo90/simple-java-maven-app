FROM openjdk:8-jdk-alpine as build
RUN apk add --no-cache maven
WORKDIR /java
COPY . /java
RUN mvn package -Dmaven.test.skip=true
EXPOSE 6969

CMD ["/bin/sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /java/target/*.jar"]