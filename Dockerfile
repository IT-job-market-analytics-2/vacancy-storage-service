FROM maven:3.9.4 AS build
WORKDIR /vacancy-storage
COPY pom.xml .
RUN mvn verify
COPY . .
RUN ["mvn", "package", "-Dmaven.test.skip=true"]

FROM openjdk:23
WORKDIR /vacancy-storage
COPY --from=build /vacancy-storage/target/*.jar vacancy-storage.jar
ENTRYPOINT ["java", "-jar", "vacancy-storage.jar"]