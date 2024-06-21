FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.war
COPY ApiSB2RestBDDto-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java","-jar","/app.war"] 