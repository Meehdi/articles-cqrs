package com.meehdi.cqrs.application.commands;

public interface CommandHandler<C> {
    void handle(C command);
}