FROM java:8
VOLUME /tmp
ADD alarm-service-1.0.0.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9091
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]