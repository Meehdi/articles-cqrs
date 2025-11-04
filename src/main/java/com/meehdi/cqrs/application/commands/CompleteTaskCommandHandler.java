package com.meehdi.cqrs.application.commands;

import com.meehdi.cqrs.domain.model.Task;
import com.meehdi.cqrs.domain.ports.TaskWriteRepository;
import org.springframework.stereotype.Service;

@Service
public class CompleteTaskCommandHandler implements CommandHandler<CompleteTaskCommand> {

    private final TaskWriteRepository repository;

    public CompleteTaskCommandHandler(TaskWriteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(CompleteTaskCommand command) {
        Task task = repository.findById(command.taskId())
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.complete();
        repository.save(task);
    }
}