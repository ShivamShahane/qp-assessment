# Use the official OpenJDK image as a base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven or Gradle build output to the container
COPY target/*.jar app.jar

# Expose the application port (default Spring Boot port)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]