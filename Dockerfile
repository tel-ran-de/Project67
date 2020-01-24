
#
# Build stage
# gradle:6.0.1-jdk11
FROM gradle:6.0.1-jdk11 as build

RUN apt-get update
RUN apt-get -y install curl gnupg
RUN curl -sL https://deb.nodesource.com/setup_12.x  | bash -
RUN apt-get -y install nodejs


COPY --chown=gradle:gradle . /home/gradle
WORKDIR /home/gradle/src/main/resources/WebApp
RUN npm install
# RUN npm root -g
#  /usr/lib/node_modules
WORKDIR /home/gradle
RUN gradle assemble



#
# Package stage
#

FROM openjdk:11-jdk-slim
COPY --from=build /home/gradle/src/blog-0.0.1-SNAPSHOT.jar /app/blog.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/blog.jar"]
