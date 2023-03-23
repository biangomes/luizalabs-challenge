FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
EXPOSE 8080
EXPOSE 3306
EXPOSE 9000
CMD ["./mvnw", "spring-boot:run"]