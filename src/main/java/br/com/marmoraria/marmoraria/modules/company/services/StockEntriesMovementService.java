package br.com.marmoraria.marmoraria.modules.company.services;

import br.com.marmoraria.marmoraria.modules.company.dtos.AddStockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.dtos.StockEntriesMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.dtos.StockWithdrawMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockEntriesMovementMapper;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockItemMapper;
import br.com.marmoraria.marmoraria.modules.company.models.StockEntriesMovement;
import br.com.marmoraria.marmoraria.modules.company.repositories.StockEntriesMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class StockEntriesMovementService {

    @Autowired
    private StockEntriesMovementMapper stockEntriesMovementMapper;

    @Autowired
    private StockEntriesMovementRepository stockEntriesMovementRepository;

    @Autowired
    private StockItemService stockItemService;

    @Autowired
    private StockItemMapper stockItemMapper;

    public void createStockEntriesMovement(StockEntriesMovement stockEntriesMovement) {
        stockEntriesMovementRepository.save(stockEntriesMovement);
    }

    public void addStockItemQuantity(UUID stockItemId, int quantity) {
        var stockItem = stockItemMapper.toEntity(stockItemService.getStockItemById(stockItemId));
        if (stockItem != null) {
            var stockEntriesMovement = new StockEntriesMovement();

            stockEntriesMovement.setMovementDate(LocalDateTime.now());
            stockEntriesMovement.setInitialQuantity(stockItem.getQuantity());
            stockEntriesMovement.setAddedQuantity(quantity);

            stockItemService.addStockItemQuantity(stockItem, quantity);

            stockEntriesMovement.setItem(stockItem);

            createStockEntriesMovement(stockEntriesMovement);
        }


    }

    public List<StockEntriesMovementDTO> getAllStockEntriesMovement() {
        return stockEntriesMovementRepository.findAll().stream().map(stockEntriesMovementMapper::toDTO).toList();
    }
}
