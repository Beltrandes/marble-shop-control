package br.com.marmoraria.marmoraria.modules.company.services;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockItemMapper;
import br.com.marmoraria.marmoraria.modules.company.models.Stock;
import br.com.marmoraria.marmoraria.modules.company.models.StockItem;
import br.com.marmoraria.marmoraria.modules.company.repositories.StockItemRepository;
import br.com.marmoraria.marmoraria.utils.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
public class StockItemService {

    @Autowired
    private StockItemRepository stockItemRepository;

    @Autowired
    private StockItemMapper stockItemMapper;

    public StockItemDTO createStockItem(StockItemDTO item) {
        return stockItemMapper.toDTO(stockItemRepository.save(stockItemMapper.toEntity(item)));
    }

    public StockItemDTO getStockItemById(UUID itemId) {
        return stockItemMapper.toDTO(stockItemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found with ID: " + itemId)));
    }

    public StockItemDTO withdrawStockItemQuantity(StockItem stockItem, int quantity) {
        if (stockItem != null) {
            var currentQuantity = stockItem.getQuantity();

            if (currentQuantity >= quantity) {
                stockItem.setQuantity(currentQuantity - quantity);
                return stockItemMapper.toDTO(stockItemRepository.save(stockItem));
            }
        }
        return null;
    }

    public StockItemDTO updateStockItem(UUID stockItemId, StockItemDTO stockItemDTO) {
        return stockItemRepository.findById(stockItemId)
                .map(recordFound -> {
                    recordFound.setName(stockItemDTO.name());
                    recordFound.setStock(stockItemDTO.stock());
                    recordFound.setQuantity(stockItemDTO.quantity());
                    recordFound.setDetails(stockItemDTO.details());
                    return stockItemMapper.toDTO(stockItemRepository.save(recordFound));
                }).orElseThrow(() -> new RuntimeException(String.valueOf(stockItemId)));
    }

    public StockItemDTO addStockItemQuantity(StockItem stockItem, int quantity) {
        if (stockItem != null) {
            stockItem.setQuantity(stockItem.getQuantity() + quantity);
            return stockItemMapper.toDTO(stockItemRepository.save(stockItem));
        }
        return null;
    }

    public void deleteStockItem(UUID stockItemId) {
        stockItemRepository.delete(stockItemRepository.findById(stockItemId)
                .orElseThrow(() -> new RuntimeException()));
    }
}
