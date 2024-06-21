FROM openjdk:17-jdk-alpine

COPY ApiSB2RestBDDto-0.0.1-SNAPSHOT.war app.war

ENTRYPOINT ["java","-jar","/app.war"] 