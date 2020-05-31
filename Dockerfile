FROM openjdk:8-jre-alpine
COPY target/benchmarks.jar /benchmarks.jar
ENTRYPOINT [ "java", "-Xms8g", "-Xmx32g", "-jar", "benchmarks.jar" ]
