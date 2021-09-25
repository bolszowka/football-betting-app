FROM openjdk:11
ADD target/football-betting-app.jar football-betting-app.jar
ENTRYPOINT ["java", "-jar", "football-betting-app.jar"]
EXPOSE 8080