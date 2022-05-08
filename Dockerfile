FROM maven:3.6.3-jdk-11-slim AS build
RUN mkdir /opt/customers
WORKDIR /opt/customers
COPY . /opt/customers
RUN mvn clean package -Dmaven.test.skip=true

FROM gcr.io/distroless/java:11
COPY --from=build /opt/customers/target/customers*.jar customers.jar
EXPOSE 8080
CMD ["customers.jar"]