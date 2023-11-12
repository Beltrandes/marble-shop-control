package br.com.marmoraria.marmoraria.modules.company.services;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockItemMapper;
import br.com.marmoraria.marmoraria.modules.company.models.StockItem;
import br.com.marmoraria.marmoraria.modules.company.repositories.StockItemRepository;
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
        return stockItemMapper.toDTO(stockItemRepository.findById(itemId).orElseThrow(null));
    }

    public StockItemDTO updateStockItemQuantity(StockItem stockItem, int quantity) {
        if (stockItem != null) {
            var currentQuantity = stockItem.getQuantity();

            if (currentQuantity >= quantity) {
                stockItem.setQuantity(currentQuantity - quantity);
                return stockItemMapper.toDTO(stockItemRepository.save(stockItem));
            }
        }
        return null;
    }
}