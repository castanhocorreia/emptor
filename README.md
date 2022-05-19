<div align="center">
  <h2 align="center">CUSTOMERS</h2>
  <h6 align="center">Application built for the Platform Builders challenge</h6>
</div>

## About

This is an application built for the technical challenge of Senior Java Developer position at [Platform Builders](https://platformbuilders.io/)

The practical case that was given is an MVP of a REST API for registering and managing customers

The application's great differential is knowing how to return resources based on path parameters, which can even be combined. The solution is done very elegantly with the help of [specification-arg-resolver](https://github.com/tkaczmarzyk/specification-arg-resolver)

With this, the API GET endpoint filters and returns the paginated results according to the parameters used, for example:

- `?fullName=Correia`
- `?fullName=Correia&birthDate=1998-07-02&email=me@castanhocorreia.com`

The endpoint even supports nested attribute field lookups:

- `?postCode=41310200`
- `?birthDate=1998-07-02&state=Bahia`

Any customer result will always return age, which is mapped according to the `birthDate` field for every response

The entire application was built on Java and Spring Framework. Of the Spring projects I used those related to Spring Data as an abstraction for the JPA provider

I used SLF4J for logging, as it is standard for Spring ecosystem

For the relational database I chose to use PostgreSQL due to its market relevance and simplicity. The database-migration tool I used is Flyway, as I had more contact with it

The retrieve method on customer service uses a simple in-memory caching because it would be over engineering to insert a Redis or something like that due to the simplicity of the application

To alleviate boilerplate I used two well-known tools: Project Lombok and MapStruct

For API documentation I used Swagger/OpenAPI

And, finally, for automated testing I used JUnit 5 for unit testing and Karate (based on Gherkin) for integration testing, using Testcontainers to embed the database

I used Karate out of personal preference, as I think it's an amazing (however, little known) tool for doing BDD tests

There is only one unit test in the code, which is to map age based on the `birthDate` field. The main focus was on end-to-end integration tests, through Karate, where all contact possibilities via API are mapped

Finally, I chose Heroku as the host for the application due to simplicity and a generous free plan. And because the application is in a cloud environment, I decided to implement a simple basic authentication solution through Spring Security, to avoid such easy exposure

## Technologies

- [Apache Maven](https://maven.apache.org/)
- [Docker](https://www.docker.com/)
- [Flyway](https://flywaydb.org/)
- [Gherkin](https://cucumber.io/docs/gherkin/)
- [Java](https://www.oracle.com/java/)
- [JUnit](https://junit.org/junit5/)
- [Karate](https://github.com/karatelabs/karate)
- [MapStruct](https://mapstruct.org/)
- [PostgreSQL](https://www.postgresql.org/)
- [Project Lombok](https://projectlombok.org/)
- [SLF4J](https://www.slf4j.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data](https://spring.io/projects/spring-data)
- [Spring Framework](https://spring.io/projects/spring-framework)
- [Spring Security](https://spring.io/projects/spring-security)
- [Swagger](https://swagger.io/)
- [Testcontainers](https://www.testcontainers.org/)

## Running

### Requisites

- Docker version 20 or higher and docker-compose
- Ports 5432 and 8080 unused

### Installation

Clone the project, and run the following command in the root directory:

```
docker-compose up -d --build
```

The API will be running on localhost, port 8080

## License

All the code on this repository is licensed under the [GNU General Public License v3.0](https://www.gnu.org/licenses/gpl-3.0.en.html)
