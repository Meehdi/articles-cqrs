package com.meehdi.cqrs.application.queries;

import com.meehdi.cqrs.domain.model.TaskStatus;
import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDetails(
        UUID id,
        String title,
        String description,
        TaskStatus status,
        LocalDateTime createdAt,
        LocalDateTime completedAt
) {
}