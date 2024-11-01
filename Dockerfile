# Use Maven to build the project
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and build the project
COPY src ./src
RUN mvn package -DskipTests

# Use Amazon Corretto for the final image
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/project-0.0.1-SNAPSHOT.jar project-0.0.1-SNAPSHOT.jar

# Run the JAR file
ENTRYPOINT ["java", "-jar", "project-0.0.1-SNAPSHOT.jar"]
