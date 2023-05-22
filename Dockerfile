FROM openjdk:11
COPY ./target/*.jar /app/project.jar
EXPOSE 8081
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=8081 -jar project.jar