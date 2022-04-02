# Online Market Application

## Requirements:
* gradle
* docker
* docker-compose

##How to setup the environment:

### Initialize MySQL database:
* sudo docker-compose up -d
* sudo docker exec -it <DOCKER_CONTAINER> sh

### Populate data manually:
* mysql -h localhost -uroot -p test < dbscript.sql

### Build and deploy the Spring Boot Application:
* gradle clean build
* java -jar build/libs/SweOnlineMarket-0.0.1-SNAPSHOT.jar

### Up the application on website:
* http://localhost:8888

