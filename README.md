# java_scaffolding
* A simple Java project scaffolding with Maven and JUnit 5.
* File Structure as follows:
```markdown
└── java_scaffolding/
    ├── java-scaffolding-common
    ├── java-scaffolding-gen
    ├── java-scaffolding-swagger
    └── java-scaffolding-test
```
* java-scaffolding-common: Contains common classes and utilities. (StringUtils, DateUtils, GlobalExceptionHandler...)
* java-scaffolding-gen: Code Generation module (Currently has entity generator)
* java-scaffolding-swagger: Swagger module (API documentation)
* java-scaffolding-test: Demo module.

## Future Enhancements
* Add sensitive data encryption/decryption.
* Add standard swagger annotations.
* Add more code generation templates. (Controller, Repository, Service, DTO...)
* Add standard log functions.
* More to come...