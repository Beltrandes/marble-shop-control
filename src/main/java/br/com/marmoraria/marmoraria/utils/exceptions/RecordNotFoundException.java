package br.com.marmoraria.marmoraria.utils.exceptions;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException(@NotNull UUID id) {
        super("Record not found for id: " + id);
    }
}
