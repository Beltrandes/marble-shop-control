package br.com.marmoraria.marmoraria.modules.company.dtos;

import br.com.marmoraria.marmoraria.modules.company.models.StockMovement;

import java.util.List;
import java.util.UUID;

public record EmployeeDTO(
        UUID id,
        String name,
        List<StockMovement> movements
) {
}
