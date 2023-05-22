FROM openjdk:11
WORKDIR /app
COPY target/*.jar /app/project.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar project.jar