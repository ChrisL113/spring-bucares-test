FROM openjdk:18-jdk-alpine3.13
ADD /target/nubedian-test.jar nubedian-test.jar
ENV INSTANCE=$INSTANCE
ENTRYPOINT ["java","-jar","nubedian-test.jar"]