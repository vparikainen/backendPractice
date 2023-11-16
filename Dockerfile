#
# Mvn Build
#
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
WORKDIR /home/app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

#
# Jar Package
#
FROM eclipse-temurin:17-jre-focal
COPY --from=build /home/app/target/backendPractice-0.0.1-SNAPSHOT.jar /usr/local/lib/backendPractice.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/backendPractice.jar"]