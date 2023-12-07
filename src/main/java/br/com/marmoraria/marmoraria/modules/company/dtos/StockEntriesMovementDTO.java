package br.com.marmoraria.marmoraria.modules.company.dtos;

import br.com.marmoraria.marmoraria.modules.company.models.StockItem;

import java.time.LocalDateTime;
import java.util.UUID;

public record StockEntriesMovementDTO(
        UUID id,
        StockItem stockItem,
        LocalDateTime movementDate,
        Integer initialQuantity,
        Integer addedQuantity
) {
}
