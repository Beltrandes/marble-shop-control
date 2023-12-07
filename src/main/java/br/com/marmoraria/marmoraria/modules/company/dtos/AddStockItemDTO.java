package br.com.marmoraria.marmoraria.modules.company.dtos;

import java.util.UUID;

public record AddStockItemDTO(
        Integer quantity,
        UUID stockItemId
) {
}
