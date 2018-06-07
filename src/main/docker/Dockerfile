FROM openjdk:8-slim
MAINTAINER voleak thol.voleak@ascendcorp.com
RUN mkdir -p /opt/tomcat/logs
RUN touch /opt/tomcat/logs/true_service.log
COPY @project.build.finalName@.jar @project.build.finalName@.jar
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
