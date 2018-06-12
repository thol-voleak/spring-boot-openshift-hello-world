FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
RUN apt-get update && apt-get install -y \
vim curl
CMD /bin/bash
ENV TZ=Asia/Phnom_Penh
RUN curl -L -O https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-6.2.4-x86_64.rpm;
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone;mkdir -p /opt/tomcat/logs/;chmod 777 /opt/tomcat/logs
COPY @project.build.finalName@.jar @project.build.finalName@.jar
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
