FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-jar","app.jar", "--spring.config.location=./application.yml"]
EXPOSE 8080
