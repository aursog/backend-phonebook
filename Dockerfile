FROM openjdk:11
ARG JARFILE=backend.jar
COPY build/libs/${JARFILE} /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]