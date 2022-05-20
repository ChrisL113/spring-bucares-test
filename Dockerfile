FROM openjdk:8-jre-alpine
ADD /target/bucarestest.jar bucarestest.jar
ENV INSTANCE=$INSTANCE
ENTRYPOINT ["java","-jar","bucarestest.jar"]




