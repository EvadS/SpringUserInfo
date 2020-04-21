FROM openjdk:8-jdk
COPY /target/app.jar /app/
COPY start.sh  /app/

WORKDIR /app

EXPOSE 8000
CMD ./start.sh