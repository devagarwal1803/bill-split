FROM openjdk:8-jdk-alpine
EXPOSE 8080
ADD /build/libs/app.jar billsplit.jar
ENTRYPOINT ["java", "-jar", "billsplit.jar"]
