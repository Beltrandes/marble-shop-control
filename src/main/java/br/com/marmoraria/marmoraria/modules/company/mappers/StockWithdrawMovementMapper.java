package br.com.marmoraria.marmoraria.modules.company.mappers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockWithdrawMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.models.StockWithdrawMovement;
import org.springframework.stereotype.Component;

@Component
public class StockWithdrawMovementMapper {

    public StockWithdrawMovementDTO toDTO(StockWithdrawMovement stockWithdrawMovement) {
        return new StockWithdrawMovementDTO(stockWithdrawMovement.getId(), stockWithdrawMovement.getMovementDate(), stockWithdrawMovement.getEmployee(), stockWithdrawMovement.getItem(), stockWithdrawMovement.getInitialQuantity(), stockWithdrawMovement.getWithdrawalQuantity());
    }

    public StockWithdrawMovement toEntity(StockWithdrawMovementDTO stockMovementDTO) {
        var stockMovement = new StockWithdrawMovement();

        stockMovement.setId(stockMovementDTO.id());
        stockMovement.setMovementDate(stockMovementDTO.movementDate());
        stockMovement.setEmployee(stockMovementDTO.employee());
        stockMovement.setItem(stockMovementDTO.stockItem());
        stockMovement.setInitialQuantity(stockMovementDTO.initialQuantity());
        stockMovement.setWithdrawalQuantity(stockMovementDTO.withdrawalQuantity());

        return stockMovement;
    }
}
