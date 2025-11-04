# CQRS with Hexagonal Architecture

Simple demonstration of CQRS pattern with Spring Boot and Hexagonal Architecture.

## Structure

```
domain/          - Business logic, entities, ports (interfaces)
application/     - Commands, queries, handlers (use cases)
infrastructure/  - REST API, JPA, adapters (implementation)
```

## Run

```bash
./gradlew bootRun
```

## API

```bash
# Create task
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Learn CQRS","description":"Study pattern"}'

# Get all tasks
curl http://localhost:8080/api/tasks

# Get task details
curl http://localhost:8080/api/tasks/{taskId}

# Complete task
curl -X PUT http://localhost:8080/api/tasks/{taskId}/complete
```

## H2 Console

http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:cqrsdb`
- Username: `sa`
- Password: (empty)