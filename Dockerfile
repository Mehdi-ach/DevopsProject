FROM openjdk:8-jdk-alpine
EXPOSE 8083
ADD target/Devops-1.0.jar Devops-1.0.jar
ENTRYPOINT ["java","-jar","/Devops-1.0.jar"]