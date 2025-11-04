package com.meehdi.cqrs.infrastructure.persistence;

import com.meehdi.cqrs.application.queries.TaskDetails;
import com.meehdi.cqrs.application.queries.TaskSummary;
import com.meehdi.cqrs.domain.model.Task;
import com.meehdi.cqrs.domain.model.TaskStatus;
import com.meehdi.cqrs.domain.ports.TaskReadRepository;
import com.meehdi.cqrs.domain.ports.TaskWriteRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class TaskRepositoryAdapter implements TaskWriteRepository, TaskReadRepository {

    private final TaskJpaRepository jpaRepository;

    public TaskRepositoryAdapter(TaskJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Task task) {
        TaskEntity entity = new TaskEntity();
        entity.setId(task.getId());
        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setStatus(task.getStatus().name());
        entity.setCreatedAt(task.getCreatedAt());
        entity.setCompletedAt(task.getCompletedAt());
        jpaRepository.save(entity);
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return jpaRepository.findById(id).map(entity -> {
            Task task = new Task(entity.getTitle(), entity.getDescription());
            return task;
        });
    }

    @Override
    public List<TaskSummary> findAllSummaries() {
        return jpaRepository.findAll().stream()
                .map(e -> new TaskSummary(e.getId(), e.getTitle(), TaskStatus.valueOf(e.getStatus())))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TaskDetails> findDetailsById(UUID id) {
        return jpaRepository.findById(id)
                .map(e -> new TaskDetails(
                        e.getId(),
                        e.getTitle(),
                        e.getDescription(),
                        TaskStatus.valueOf(e.getStatus()),
                        e.getCreatedAt(),
                        e.getCompletedAt()
                ));
    }
}