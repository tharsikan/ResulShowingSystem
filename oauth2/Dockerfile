FROM java:8
EXPOSE 7676:7676
ADD /target/oauth2-service.jar oauth2-service.jar
ENTRYPOINT ["java","-jar","oauth2-service.jar"]