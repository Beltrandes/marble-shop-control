package br.com.marmoraria.marmoraria.modules.company.mappers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockDTO;
import br.com.marmoraria.marmoraria.modules.company.models.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockMapper {

    public StockDTO toDTO(Stock stock) {
        return new StockDTO(stock.getId(), stock.getName(), stock.getItems());
    }

    public Stock toEntity(StockDTO stockDTO) {
        Stock stock = new Stock();

        stock.setId(stockDTO.id());
        stock.setName(stockDTO.name());
        stock.setItems(stockDTO.items());

        return stock;
    }
}
