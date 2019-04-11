FROM openjdk:8-slim
MAINTAINER Thol Voleak <volak.tho@ascendcorp.com>
COPY @project.build.finalName@.jar @project.build.finalName@.jar
VOLUME /opt/tomcat/logs
#ENV TZ=Asia/Phnom_Penh
#RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
RUN mkdir -p /opt/tomcat/logs && chmod 777 /opt/tomcat/logs
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
