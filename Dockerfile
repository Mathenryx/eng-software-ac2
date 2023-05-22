FROM openjdk:11
WORKDIR /project
COPY ./target/*.jar /project/project.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar project.jar