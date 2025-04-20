#!/bin/sh

exec java $JAVA_OPTS -jar /app.jar --server.port=${PORT:-8080}