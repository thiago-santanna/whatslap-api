package com.tsswebapps.lapinformatica.whatslap.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ResponseExceptionHandler(
        String message,
        LocalDateTime momentError,
        String path
) {}
