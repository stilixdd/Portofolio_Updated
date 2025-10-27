# --- Build stage: compile the Spring Boot app ---
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw && ./mvnw -B -DskipTests package

# --- Run stage: lightweight JRE image to run the jar ---
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENV PORT=8080
EXPOSE 8080
CMD ["sh", "-c", "java -Dserver.port=$PORT -jar app.jar"]
