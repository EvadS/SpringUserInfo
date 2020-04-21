#!/bin/sh

java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5006 -Djava.security.egd=file:/dev/./urandom  -jar   app.jar



