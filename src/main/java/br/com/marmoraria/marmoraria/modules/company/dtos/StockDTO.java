package br.com.marmoraria.marmoraria.modules.company.dtos;

import br.com.marmoraria.marmoraria.modules.company.models.StockItem;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;

import java.util.List;
import java.util.UUID;

public record StockDTO(
        UUID id,
        @NotBlank @NonNull @Column(unique = true) String name,
        List<StockItem> items
) {
}
