package br.com.marmoraria.marmoraria.modules.company.mappers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.models.Stock;
import br.com.marmoraria.marmoraria.modules.company.models.StockItem;
import org.springframework.stereotype.Component;

@Component
public class StockItemMapper {

    public StockItemDTO toDTO(StockItem item) {
        return new StockItemDTO(item.getId(), item.getName(), item.getDetails(), item.getQuantity(), item.getStock(), item.getMovements());
    }

    public StockItem toEntity(StockItemDTO itemDTO) {
        var item = new StockItem();

        item.setId(itemDTO.id());
        item.setName(itemDTO.name());
        item.setDetails(itemDTO.details());
        item.setQuantity(itemDTO.quantity());
        item.setStock(itemDTO.stock());
        item.setMovements(itemDTO.movements());

        return item;
    }
}
