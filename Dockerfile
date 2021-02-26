FROM openjdk:15

COPY target/dockerizing-consumer-*.jar dockerizing-consumer.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/dockerizing-consumer.jar"]