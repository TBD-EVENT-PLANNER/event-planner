#
# BUILD STAGE
#
FROM gradle:8.5-jdk21-alpine AS build
WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY gradle ./gradle
COPY gradlew ./gradlew
COPY src ./src

RUN chmod +x gradlew && \
    sh ./gradlew clean build -x test -x checkstyleMain -no-daemon --build-cache --parallel

#
# PACKAGE STAGE
#
FROM openjdk:21-slim

WORKDIR /app

ENV JAR_FILE=tbd-event-planner-1.0.jar

COPY --from=build /app/build/libs/${JAR_FILE} /app/application.jar

CMD ["java", "-jar", "/app/application.jar", "--spring.profiles.active=k8s"]
