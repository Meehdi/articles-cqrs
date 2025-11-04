package com.meehdi.cqrs.infrastructure.api;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskRequest(
        @NotBlank(message = "Title is required") String title,
        String description
) {
}