FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
ENV TZ=Asia/Phnom_Penh
#COPY . /apps
#WORKDIR /apps
RUN pwd
COPY target/*.jar deployment.jar
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/myapp.jar"]
