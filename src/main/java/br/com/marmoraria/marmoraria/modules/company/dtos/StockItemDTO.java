package br.com.marmoraria.marmoraria.modules.company.dtos;

import br.com.marmoraria.marmoraria.modules.company.models.Stock;
import br.com.marmoraria.marmoraria.modules.company.models.StockEntriesMovement;
import br.com.marmoraria.marmoraria.modules.company.models.StockWithdrawMovement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public record StockItemDTO(
        UUID id,
        String name,
        String details,
        Integer quantity,
        Stock stock,
        List<StockWithdrawMovement> withdrawMovements,
        List<StockEntriesMovement> entriesMovements

) {
}
