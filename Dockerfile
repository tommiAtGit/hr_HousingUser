FROM adoptopenjdk/openjdk14:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=target/housingUser-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 9092
ENTRYPOINT ["java","-jar","app.jar"]