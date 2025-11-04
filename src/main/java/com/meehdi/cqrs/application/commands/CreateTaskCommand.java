package com.meehdi.cqrs.application.commands;

public record CreateTaskCommand(String title, String description) {
}