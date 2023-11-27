package br.com.marmoraria.marmoraria.modules.company.dtos;

import java.util.UUID;

public record WithdrawStockItemDTO(

        UUID employeeId,
        UUID stockItemId,
        Integer quantity
) {
}
