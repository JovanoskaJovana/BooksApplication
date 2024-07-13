FROM openjdk:17-jdk

WORKDIR /app
COPY target/BooksApplication-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 9090

CMD ["java", "-jar", "app.jar"]
