FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
ENV TZ=Asia/Phnom_Penh
RUN ls /home/
COPY /target/*.jar /home/myapp.jar
RUN ls /home/
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/home/myapp.jar"]
