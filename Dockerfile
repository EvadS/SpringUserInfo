FROM openjdk:8-jdk
COPY /target/app.jar /app/

WORKDIR /app

EXPOSE 8000

ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5006  -Xms1024M -Xmx1536M", "-jar", "app.jar"]