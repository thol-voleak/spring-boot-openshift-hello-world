FROM openjdk:8-slim
MAINTAINER Thol-Voleak <thol.voleak@gmail.com>
ENV TZ=Asia/Phnom_Penh
ENV FILEBEAT_VERSION=1.2.3 \
    FILEBEAT_SHA1=3fde7f5f5ea837140965a193bbb387c131c16d9c
COPY @project.build.finalName@.jar @project.build.finalName@.jar
RUN apt-get update && apt-get install -y \
vim
RUN set -x && \
  apt-get update && \
  apt-get install -y wget && \
  wget https://download.elastic.co/beats/filebeat/filebeat-${FILEBEAT_VERSION}-x86_64.tar.gz -O /etc/filebeat.tar.gz && \
  cd /etc && \
  echo "${FILEBEAT_SHA1}  filebeat.tar.gz" | sha1sum -c - && \
  tar xzvf filebeat.tar.gz && \
  mv filebeat-* filebeat && \
  cd filebeat && \
  cp filebeat /bin && \
  cd /etc && \
  apt-get purge -y wget && \
  apt-get autoremove -y && \
  apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
CMD /bin/bash
LABEL release-date="@timestamp@"
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/@project.build.finalName@.jar"]
