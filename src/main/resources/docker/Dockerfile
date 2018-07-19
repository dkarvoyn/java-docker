FROM java:8
RUN useradd user
USER user
WORKDIR /home/user/rest-api
ADD /libs/rest-api-1.0-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java"]
CMD ["-jar", "./rest-api-1.0-SNAPSHOT.jar"]