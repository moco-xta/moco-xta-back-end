# FROM openjdk:21
# VOLUME /tmp
# EXPOSE 8080
# COPY target/moco-xta-back-end-0.0.1-SNAPSHOT.jar moco-xta-back-end.jar
# ENTRYPOINT ["java","-jar","/moco-xta-back-end.jar"]

FROM openjdk:21
# VOLUME /tmp
# ARG JAVA_OPTS
# ENV JAVA_OPTS=$JAVA_OPTS
# COPY target/dbtest-0.0.1-SNAPSHOT.jar dbtest.jar
# EXPOSE 8080
# ENTRYPOINT exec java $JAVA_OPTS -jar dbtest.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar dbtest.jar

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
CMD ["./mvnw", "spring-boot:run"]