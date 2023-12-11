FROM eclipse-temurin:17-jammy AS build

#RUN apt-get update
#RUN apt-get install openjdk:22-slim -y
#COPY . .

RUN apt-get install maven -y
RUN mvn clean install

#FROM openjdk:20-jdk-slim

EXPOSE 8080

COPY --from=build /target/PudimDouroAPI-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]