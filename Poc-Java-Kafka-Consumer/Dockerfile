FROM openjdk:11
COPY ./target/*.jar /app/aplicacao.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "aplicacao.jar"]
EXPOSE 10000