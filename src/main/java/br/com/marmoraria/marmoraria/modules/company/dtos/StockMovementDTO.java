package br.com.marmoraria.marmoraria.modules.company.dtos;

import br.com.marmoraria.marmoraria.modules.company.models.Employee;
import br.com.marmoraria.marmoraria.modules.company.models.StockItem;

import java.time.LocalDateTime;
import java.util.UUID;

public record StockMovementDTO(
        UUID id,
        LocalDateTime movementDate,
        Employee employee,
        StockItem stockItem,
        Integer initialQuantity,
        Integer withdrawalQuantity
) {
}
