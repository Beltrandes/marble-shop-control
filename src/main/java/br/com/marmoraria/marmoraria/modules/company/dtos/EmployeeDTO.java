package br.com.marmoraria.marmoraria.modules.company.dtos;

import br.com.marmoraria.marmoraria.modules.company.models.StockWithdrawMovement;

import java.util.List;
import java.util.UUID;

public record EmployeeDTO(
        UUID id,
        String name,
        List<StockWithdrawMovement> movements
) {
}
