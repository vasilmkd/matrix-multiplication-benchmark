FROM openjdk:8-jre-alpine
COPY target/benchmarks.jar /benchmarks.jar
ENTRYPOINT [ "java", "-Xms16g", "-Xmx64g", "-jar", "benchmarks.jar" ]
