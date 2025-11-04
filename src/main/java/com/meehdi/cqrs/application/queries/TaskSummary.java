package com.meehdi.cqrs.application.queries;

import com.meehdi.cqrs.domain.model.TaskStatus;
import java.util.UUID;

public record TaskSummary(UUID id, String title, TaskStatus status) {
}