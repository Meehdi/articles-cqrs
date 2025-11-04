package com.meehdi.cqrs.domain.ports;

import com.meehdi.cqrs.application.queries.TaskDetails;
import com.meehdi.cqrs.application.queries.TaskSummary;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskReadRepository {
    List<TaskSummary> findAllSummaries();
    Optional<TaskDetails> findDetailsById(UUID id);
}