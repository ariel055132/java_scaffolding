# Java-Scaffolding-Swagger
## Introduction
* API documentation plays a crucial role in modern software development.
* It not only provides clear instructions on how you application works, but also helps other developers understand, use, and integrate services more easily.
* However, manually creating and maintaining API documentation can be a tedious and error-prone process.
* Therefore, **SpringDoc OpenAPI** is introduced.

## What is SpringDoc OpenAPI?
* A tool for automatically generating API documentation, specifically optimized for Spring Boot Projects,
* It is based on OpenAPI 3.0 specification and aims to simplify the process of generating API documentation while providing rich customization and extension features.
* It achieves following objectives:
  1. Reduce the workload of manual documentation
     * Developers do not need to spend a lot of time manually writing API documentation, but let the tool handle this task automatically.
  2. Improve documentation consistency: The generated documentation conforms to standards and maintains consistency, which helps other developers understand and use your API more easily
  3. Provide customization and extension features: SpringDoc OpenAPI allows you to customize according to the needs of the project, including adding custom descriptions, grouping, and tags.
  4. Integrate with Spring Boot: Seamlessly integrates with Spring Boot and can be easily added to existing Spring Boot projects.

## How to use
1. Add the following dependencies to your `pom.xml` file:
```xml
<dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>${springdoc-openapi-starter-webmvc-ui.version}</version>
</dependency>
```

2. Setup SpringDoc OpenAPI properties to your `application.properties / application.yml` file:
* After adding the dependencies, you need to configure SpringDoc OpenAPI in your application (e.g., `application.properties` or `application.yml`).
* Here is an example of how to configure SpringDoc OpenAPI in `application.properties`:
```properties
springdoc.api-docs.path=/v3/api-docs # The Path of the generated OpenAPI documentation
springdoc.swagger-ui.path=/swagger-ui.html # Swagger UI Path
```
* The API documentation Path: http://localhost:8080/v3/api-docs
* The Swagger UI Path: http://localhost:8080/swagger-ui.html
* Port 8080 is default port for Spring Boot, you can change it according to your project configuration.

3. Create a configuration to define the information of OpenAPI
* @OpenAPIDefinition & @Configuration annotation to be used to define the information of OpenAPI.
* Put the basic message to the OpenAPI object
```java
@OpenAPIDefinition
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Base Documentation")
                        .description("Base API Documentation")
                        .version("1.0.0")
                        .license(new License().name("Your License").url("http://springdoc.org"))
                        .contact(new Contact().name("Your Name").email("ex").url("http://springdoc.org"))
                );
    }
}
```

4. Activate the application and visit the API documentation URL

## Notes
* How to use the swagger config to another module?
* Scan the package of the swagger config before activate the application.

