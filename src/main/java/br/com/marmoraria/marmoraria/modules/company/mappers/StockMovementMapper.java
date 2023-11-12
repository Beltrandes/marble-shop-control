package br.com.marmoraria.marmoraria.modules.company.mappers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.models.StockMovement;
import org.springframework.stereotype.Component;

@Component
public class StockMovementMapper {

    public StockMovementDTO toDTO(StockMovement stockMovement) {
        return new StockMovementDTO(stockMovement.getId(), stockMovement.getMovementDate(), stockMovement.getEmployee(), stockMovement.getItem(), stockMovement.getInitialQuantity(), stockMovement.getWithdrawalQuantity());
    }

    public StockMovement toEntity(StockMovementDTO stockMovementDTO) {
        var stockMovement = new StockMovement();

        stockMovement.setId(stockMovementDTO.id());
        stockMovement.setMovementDate(stockMovementDTO.movementDate());
        stockMovement.setEmployee(stockMovementDTO.employee());
        stockMovement.setItem(stockMovementDTO.stockItem());
        stockMovement.setInitialQuantity(stockMovementDTO.initialQuantity());
        stockMovement.setWithdrawalQuantity(stockMovementDTO.withdrawalQuantity());

        return stockMovement;
    }
}
