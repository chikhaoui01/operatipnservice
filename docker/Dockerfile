FROM openjdk:11-jre
WORKDIR /opt
EXPOSE 8080
COPY target/operatipnservice-0.0.1-SNAPSHOT.jar ./app.jar
CMD ["java", "-jar","-Dspring.profiles.active=docker", "app.jar"]
