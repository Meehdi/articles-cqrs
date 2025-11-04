package com.meehdi.cqrs.application.commands;

import com.meehdi.cqrs.domain.model.Task;
import com.meehdi.cqrs.domain.ports.TaskWriteRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskCommandHandler implements CommandHandler<CreateTaskCommand> {

    private final TaskWriteRepository repository;

    public CreateTaskCommandHandler(TaskWriteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void handle(CreateTaskCommand command) {
        Task task = new Task(command.title(), command.description());
        repository.save(task);
    }
}