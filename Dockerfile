FROM store/oracle/serverjre:1.8.0_241-b07
ADD /target/bucarestest.jar bucarestest.jar
ENV INSTANCE=$INSTANCE
ENTRYPOINT ["java","-jar","bucarestest.jar"]