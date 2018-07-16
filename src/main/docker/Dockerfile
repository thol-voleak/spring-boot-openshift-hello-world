FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
ENV TZ=Asia/Phnom_Penh
COPY *.jar mayapp.jar
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mayapp.jar"]
