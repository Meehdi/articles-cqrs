package com.meehdi.cqrs.application.commands;

import java.util.UUID;

public record CompleteTaskCommand(UUID taskId) {
}