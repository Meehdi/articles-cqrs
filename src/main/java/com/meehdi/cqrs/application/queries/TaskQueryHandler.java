package com.meehdi.cqrs.application.queries;

import com.meehdi.cqrs.domain.ports.TaskReadRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskQueryHandler {

    private final TaskReadRepository repository;

    public TaskQueryHandler(TaskReadRepository repository) {
        this.repository = repository;
    }

    public List<TaskSummary> handle(TaskSummaryQuery query) {
        return repository.findAllSummaries();
    }

    public TaskDetails handle(TaskDetailsQuery query) {
        return repository.findDetailsById(query.taskId())
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }
}