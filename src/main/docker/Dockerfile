FROM openjdk:8-slim
MAINTAINER voleak thol.voleak@ascendcorp.com
COPY target/@project.build.finalName@.jar target/@project.build.finalName@.jar
VOLUME /opt/tomcat/logs
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
