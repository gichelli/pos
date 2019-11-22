FROM maven:3.5-jdk-8
VOLUME /tmp
ADD target/pos-0.0.1-SNAPSHOT.jar pos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","pos-0.0.1-SNAPSHOT.jar"]