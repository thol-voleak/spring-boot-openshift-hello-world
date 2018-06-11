FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
RUN apt-get update && apt-get install -y \
vim curl
CMD /bin/bash
ENV TZ=Asia/Phnom_Penh
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone;touch /var/log/test.log ; chmod 777 /var/log/test.log
COPY @project.build.finalName@.jar @project.build.finalName@.jar
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
