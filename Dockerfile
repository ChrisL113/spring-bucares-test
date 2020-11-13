FROM openjdk:8-jre-alpine
ADD /target/bucarestest.jar bucarestest.jar
ENTRYPOINT ["java","-jar","bucarestest.jar"]