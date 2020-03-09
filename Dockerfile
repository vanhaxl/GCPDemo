FROM docker.prod.walmart.com/library/openjdkcpes:8-jdk-alpine

EXPOSE 8080

ARG envTarget
ARG GOOGLE_APPLICATION_CREDENTIALS

ENV envTarget=$envTarget
ENV GOOGLE_APPLICATION_CREDENTIALS=$GOOGLE_APPLICATION_CREDENTIALS

COPY target/GCPDemo-*.jar /home/srt-alert.jar
ENTRYPOINT java -DenvTarget=$envTarget -DGOOGLE_APPLICATION_CREDENTIALS=$GOOGLE_APPLICATION_CREDENTIALS -jar /home/srt-alert.jar