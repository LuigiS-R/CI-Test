# Build the application; tests run elsewhere in the CI pipeline.
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn --batch-mode package -DskipTests

# Run the compiled application in a minimal Java runtime.
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=build /app/target/hello-ci-world-1.0.0.jar app.jar

ENTRYPOINT ["java", "-cp", "app.jar", "Main"]
