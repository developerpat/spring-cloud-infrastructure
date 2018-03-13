FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} /usr/src/springapp/netflix-eureka-naming-server.jar
WORKDIR /usr/src/springapp
EXPOSE 8761
CMD [ "java","-jar", "netflix-eureka-naming-server.jar" ]