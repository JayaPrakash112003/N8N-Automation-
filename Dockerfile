# -----------------------------
# BUILD STAGE
# -----------------------------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml first (for caching)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build the JAR
RUN mvn clean package -DskipTests


# -----------------------------
# RUNTIME STAGE
# -----------------------------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built JAR from build stage
COPY --from=build /app/target/app.jar app.jar

# Expose port (Render uses 8080)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"]
