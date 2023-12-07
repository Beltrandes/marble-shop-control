package br.com.marmoraria.marmoraria.modules.company.mappers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockEntriesMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.models.StockEntriesMovement;
import org.springframework.stereotype.Component;

@Component
public class StockEntriesMovementMapper {

    public StockEntriesMovementDTO toDTO(StockEntriesMovement stockEntriesMovement) {
        return new StockEntriesMovementDTO(stockEntriesMovement.getId(), stockEntriesMovement.getItem(),stockEntriesMovement.getMovementDate() ,stockEntriesMovement.getInitialQuantity(), stockEntriesMovement.getAddedQuantity());
    }

    public StockEntriesMovement toEntity(StockEntriesMovementDTO stockEntriesMovementDTO) {
        var stockEntriesMovement = new StockEntriesMovement();

        stockEntriesMovement.setId(stockEntriesMovementDTO.id());
        stockEntriesMovement.setMovementDate(stockEntriesMovementDTO.movementDate());
        stockEntriesMovement.setItem(stockEntriesMovementDTO.stockItem());
        stockEntriesMovement.setInitialQuantity(stockEntriesMovementDTO.initialQuantity());
        stockEntriesMovement.setAddedQuantity(stockEntriesMovementDTO.addedQuantity());

        return stockEntriesMovement;
    }
}
