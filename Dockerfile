FROM openjdk:8u121-jre-alpine
ADD target/URLShortener-0.0.1-SNAPSHOT.jar URLShortener-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -jar /URLShortener-0.0.1-SNAPSHOT.jar"]
