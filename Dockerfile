FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/app.jar bill-split-hu17-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "bill-split-hu17-1.0-SNAPSHOT.jar"]
