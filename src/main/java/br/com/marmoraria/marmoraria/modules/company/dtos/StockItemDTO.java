package br.com.marmoraria.marmoraria.modules.company.dtos;

import br.com.marmoraria.marmoraria.modules.company.models.Stock;
import br.com.marmoraria.marmoraria.modules.company.models.StockMovement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public record StockItemDTO(
        UUID id,
        @NotBlank @NonNull String name,
        String details,
        @NotNull Integer quantity,
        Stock stock,
        List<StockMovement> movements

) {
}
