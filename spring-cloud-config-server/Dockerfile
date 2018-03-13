FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} /usr/src/springapp/spring-cloud-config-server.jar
WORKDIR /usr/src/springapp
EXPOSE 8761
CMD [ "java","-jar", "spring-cloud-config-server.jar" ]