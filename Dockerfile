FROM adoptopenjdk/openjdk11:alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

ADD target/ecommerce.jar ecommerce.jar
CMD ["java","-jar","ecommerce.jar"]