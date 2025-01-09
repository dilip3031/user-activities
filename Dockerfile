#FROM eclipse-temurin:17-jdk-alpine
FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY target/*.jar user_activities.jar
ENTRYPOINT ["java","-jar","/user_activities.jar"]
EXPOSE 8090