package com.meehdi.cqrs.domain.ports;

import com.meehdi.cqrs.domain.model.Task;
import java.util.Optional;
import java.util.UUID;

public interface TaskWriteRepository {
    void save(Task task);
    Optional<Task> findById(UUID id);
}