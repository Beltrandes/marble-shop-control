package br.com.marmoraria.marmoraria.modules.company.services;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockWithdrawMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.mappers.EmployeeMapper;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockItemMapper;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockWithdrawMovementMapper;
import br.com.marmoraria.marmoraria.modules.company.models.StockWithdrawMovement;
import br.com.marmoraria.marmoraria.modules.company.repositories.StockWithdrawMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Validated
public class StockWithdrawMovementService {

    @Autowired
    private StockWithdrawMovementRepository stockWithdrawMovementRepository;

    @Autowired
    private StockWithdrawMovementMapper stockWithdrawMovementMapper;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StockItemService stockItemService;

    @Autowired
    private StockItemMapper stockItemMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public void createStockWithdrawMovement(StockWithdrawMovement stockWithdrawMovement) {
        stockWithdrawMovementRepository.save(stockWithdrawMovement);
    }

    public void employeeSubtractItemQuantity(UUID stockItemId, int quantity, UUID employeeId) {
        var stockItem = stockItemMapper.toEntity(stockItemService.getStockItemById(stockItemId));
        if (stockItem != null) {
            var employee = employeeMapper.toEntity(employeeService.getEmployeeById(employeeId));
            if (employee != null) {
                if (stockItem.getQuantity() < quantity) {
                    throw new IllegalArgumentException("Insufficient stock quantity");
                }
                var stockMovement = new StockWithdrawMovement();
                stockMovement.setEmployee(employee);
                stockMovement.setMovementDate(LocalDateTime.now());
                stockMovement.setInitialQuantity(stockItem.getQuantity());
                stockMovement.setWithdrawalQuantity(quantity);

                stockItemService.withdrawStockItemQuantity(stockItem, quantity);

                stockMovement.setItem(stockItem);

                createStockWithdrawMovement(stockMovement);
            }
        }
    }

    public List<StockWithdrawMovementDTO> getAllStockWithdrawMovements() {
        return stockWithdrawMovementRepository.findAll().stream().map(stockWithdrawMovementMapper::toDTO).toList();
    }
}
