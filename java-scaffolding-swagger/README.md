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
  1. Reduce the workload of manual documentation: Developers do not need to spend a lot of time manually writing API documentation, but let the tool handle this task automatically.
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

2. Add configuration / Setup SpringDoc OpenAPI to your `application.properties / application.yml` file:
