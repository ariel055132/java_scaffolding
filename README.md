# java_scaffolding
* A simple Java project scaffolding with Maven and JUnit 5.
* File Structure as follows:
```markdown
└── java_scaffolding/
    ├── java-scaffolding-common
    ├── java-scaffolding-gen
    ├── java-scaffolding-sensitive
    ├── java-scaffolding-swagger
    └── java-scaffolding-test
```
* java-scaffolding-common
  * Contains common classes and utilities. (StringUtils, DateUtils, GlobalExceptionHandler...)
* java-scaffolding-gen
  * Code Generation module (Currently has entity generator)
* java-scaffolding-sensitive
  * Sensitive data encryption module. 
* java-scaffolding-swagger
  * Swagger module (API documentation)
* java-scaffolding-test
  * Demo module.

## Future Enhancements
- [x] Add sensitive data encryption. 
- [x] Add standard swagger annotations. 
- [ ] Add more code generation templates. (Controller, Repository, Service, DTO...)
- [ ] Add standard log functions.
- [ ] Json serialization and deserialization. 
* More to come...