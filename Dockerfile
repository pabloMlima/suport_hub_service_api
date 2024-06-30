FROM openjdk:17-jdk-slim

EXPOSE 8080

RUN mkdir -p /app

# Adicionando um diretório temporário para debug
COPY . /temp/
RUN ls -la /temp/build/libs/

COPY build/libs/*.jar /app/suport_hub_service.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/suport_hub_service.jar"]
