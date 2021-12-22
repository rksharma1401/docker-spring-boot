FROM openjdk:8-jdk-alpine
# Downloading and installing Maven
 
# 6- Define environmental variables required by Maven, like Maven_Home directory and where the maven repo is located
ENV MAVEN_HOME /root/apache-maven-3.8.4/
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"
RUN /root/apache-maven-3.8.4/bin/mvn clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
