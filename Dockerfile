FROM openjdk:8-jre
COPY target/benchmarks.jar /benchmarks.jar
ENTRYPOINT [ "java", "-Xms4g", "-Xmx16g", "-jar", "benchmarks.jar" ]
