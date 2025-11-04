package com.meehdi.cqrs.infrastructure.api;

import com.meehdi.cqrs.application.commands.*;
import com.meehdi.cqrs.application.queries.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final CreateTaskCommandHandler createHandler;
    private final CompleteTaskCommandHandler completeHandler;
    private final TaskQueryHandler queryHandler;

    public TaskController(CreateTaskCommandHandler createHandler,
                          CompleteTaskCommandHandler completeHandler,
                          TaskQueryHandler queryHandler) {
        this.createHandler = createHandler;
        this.completeHandler = completeHandler;
        this.queryHandler = queryHandler;
    }

    @PostMapping
    public ResponseEntity<Void> createTask(@Valid @RequestBody CreateTaskRequest request) {
        createHandler.handle(new CreateTaskCommand(request.title(), request.description()));
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{taskId}/complete")
    public ResponseEntity<Void> completeTask(@PathVariable UUID taskId) {
        completeHandler.handle(new CompleteTaskCommand(taskId));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TaskSummary>> getTasks() {
        return ResponseEntity.ok(queryHandler.handle(new TaskSummaryQuery()));
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDetails> getTask(@PathVariable UUID taskId) {
        return ResponseEntity.ok(queryHandler.handle(new TaskDetailsQuery(taskId)));
    }
}