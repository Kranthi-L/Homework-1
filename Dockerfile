# Use the official OpenJDK image as a base
FROM openjdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar

# Expose the port on which your API runs
EXPOSE 8080

# Run the JAR file when the container starts
CMD ["java", "-jar", "app.jar"]