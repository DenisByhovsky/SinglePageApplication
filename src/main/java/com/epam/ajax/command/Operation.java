package com.epam.ajax.command;

import java.util.Arrays;

public enum Operation {

    NO_COMMAND,
    ADD_VAL,
    DELETE_VAL,
    CHANGE_VAL,
    UPDATE_VAL;

    public static Operation convert(String command) {
        Operation operation = Arrays.stream(values()).
                filter(it -> it.name().equalsIgnoreCase(command)).findFirst().orElse(NO_COMMAND);
        return operation;
    }
}
