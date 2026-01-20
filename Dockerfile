# Playwright official Java image (includes Chromium + deps)
FROM mcr.microsoft.com/playwright/java:v1.42.0-jammy

# Set working directory
WORKDIR /app

# Copy Maven config first (for cache)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy source code
COPY src ./src

# Build Spring Boot JAR
RUN mvn package -DskipTests

# Expose Render port
EXPOSE 8080

# Run Spring Boot app
CMD ["java", "-jar", "target/zepto-automation-1.0.0.jar"]

