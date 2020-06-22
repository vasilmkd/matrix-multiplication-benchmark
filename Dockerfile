FROM openjdk:8-jre
COPY target/benchmarks.jar /benchmarks.jar
ENTRYPOINT [ "java", "-Xms2g", "-Xmx8g", "-jar", "benchmarks.jar" ]
