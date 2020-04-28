FROM java:8
EXPOSE 8011:8011
ADD /target/student-service.jar student-service.jar
ENTRYPOINT ["java","-jar","student-service.jar"]