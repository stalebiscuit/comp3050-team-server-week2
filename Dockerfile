FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY Test.java HelloHandler.java ./
RUN javac Test.java
EXPOSE 8000
CMD ["java", "Test"]
