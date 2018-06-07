FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
RUN /bin/bash -c 'touch /var/log/test.log'
COPY @project.build.finalName@.jar @project.build.finalName@.jar
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
