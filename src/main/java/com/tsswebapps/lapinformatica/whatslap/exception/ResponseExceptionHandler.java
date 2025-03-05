package com.tsswebapps.lapinformatica.whatslap.exception;

import java.time.LocalDateTime;

public record ResponseExceptionHandler(
        String message,
        LocalDateTime momentError,
        String path
) {}
