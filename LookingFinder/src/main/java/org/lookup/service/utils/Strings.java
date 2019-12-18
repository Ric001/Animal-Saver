package org.lookup.service.utils;

import java.util.Optional;

public class Strings {
    public static boolean isNullOrEmpty(Optional<String> string) {
        return (string.isPresent() || (string.get().isEmpty()));
    }

    public static boolean isNullOrEmpty(String value) {
        return (value == null || value.isEmpty());
    }
}