FROM openjdk:alpine

ADD ./target/springcloud_service_1-1.0.jar /app/
RUN mkdir -p /app/servlet/logs
CMD ["sh", "-c", "cd /app; java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app/springcloud_service_1-1.0.jar ${RUN_ARGS}"]

EXPOSE 8081