FROM eclipse-temurin:17-jre-jammy

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# application-dev.yml 내용을 환경 변수에서 받아서 파일로 저장
ARG APP_CONFIG
RUN mkdir /config && echo "$APP_CONFIG" > /config/application-dev.yml

ENTRYPOINT ["java","-Dspring.config.location=classpath:/application.yml,/config/application-dev.yml","-jar","/app.jar"]
