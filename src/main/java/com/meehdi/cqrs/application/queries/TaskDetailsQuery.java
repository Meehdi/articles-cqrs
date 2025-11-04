package com.meehdi.cqrs.application.queries;

import java.util.UUID;

public record TaskDetailsQuery(UUID taskId) {
}