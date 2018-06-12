FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
RUN apt-get update && apt-get install -y \
vim curl rpm
CMD /bin/bash
ENV TZ=Asia/Phnom_Penh
RUN apt install wget
RUN wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch | sudo apt-key add -
RUN apt-get install apt-transport-https
RUN echo "deb https://artifacts.elastic.co/packages/6.x/apt stable main" | tee -a /etc/apt/sources.list.d/elastic-6.x.list
RUN apt-get update && apt-get install filebeat
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone;mkdir -p /opt/tomcat/logs/;chmod 777 /opt/tomcat/logs
COPY @project.build.finalName@.jar @project.build.finalName@.jar
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
