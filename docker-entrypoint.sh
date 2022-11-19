#!/bin/sh

exec java -jar /app.jar --server.port=${PORT:-8080}