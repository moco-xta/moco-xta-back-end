FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
COPY target/moco-xta-back-end-0.0.1-SNAPSHOT.jar moco-xta-back-end.jar
ENTRYPOINT ["java","-jar","/moco-xta-back-end.jar"]