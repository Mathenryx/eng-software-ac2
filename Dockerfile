FROM openjdk:11
WORKDIR /eng-software-ac2
COPY ./target/*.jar /eng-software-ac2/project.jar
EXPOSE 9090
CMD java -XX:+UseContainerSupport -Xmx512m -Dserver.port=9090 -jar project.jar