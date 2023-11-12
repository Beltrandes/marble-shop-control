package br.com.marmoraria.marmoraria.modules.company.services;

import br.com.marmoraria.marmoraria.modules.company.mappers.EmployeeMapper;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockItemMapper;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockMovementMapper;
import br.com.marmoraria.marmoraria.modules.company.models.Employee;
import br.com.marmoraria.marmoraria.modules.company.models.StockItem;
import br.com.marmoraria.marmoraria.modules.company.models.StockMovement;
import br.com.marmoraria.marmoraria.modules.company.repositories.StockMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Validated
public class StockMovementService {

    @Autowired
    private StockMovementRepository stockMovementRepository;

    @Autowired
    private StockMovementMapper stockMovementMapper;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StockItemService stockItemService;

    @Autowired
    private StockItemMapper stockItemMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public void createStockMovement(StockMovement stockMovement) {
        stockMovementRepository.save(stockMovement);
    }

    public void employeeSubtractItemQuantity(UUID stockItemId, int quantity, UUID employeeId) {
        var stockItem = stockItemMapper.toEntity(stockItemService.getStockItemById(stockItemId));
        if (stockItem != null) {
            var employee = employeeMapper.toEntity(employeeService.getEmployeeById(employeeId));
            if (employee != null) {
                if (stockItem.getQuantity() < quantity) {
                    throw new IllegalArgumentException("Insufficient stock quantity");
                }
                var stockMovement = new StockMovement();
                stockMovement.setEmployee(employee);
                stockMovement.setMovementDate(LocalDateTime.now());
                stockMovement.setInitialQuantity(stockItem.getQuantity());
                stockMovement.setWithdrawalQuantity(quantity);

                stockItemService.updateStockItemQuantity(stockItem, quantity);

                stockMovement.setItem(stockItem);

                createStockMovement(stockMovement);
            }
        }
    }
}
