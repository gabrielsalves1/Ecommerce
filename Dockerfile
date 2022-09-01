FROM openjdk:11
ADD target/ecommerce-docker.jar ecommerce-docker.jar
ENTRYPOINT ["java", "-jar","ecommerce-docker.jar"]
EXPOSE 8080