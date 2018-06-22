FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
ENV TZ=Asia/Phnom_Penh
COPY @project.build.finalName@.jar @project.build.finalName@.jar
RUN apt-get update && apt-get install -y \
curl
CMD /bin/bash
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
