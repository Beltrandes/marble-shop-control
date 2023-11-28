package br.com.marmoraria.marmoraria.modules.company.services;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockDTO;
import br.com.marmoraria.marmoraria.modules.company.mappers.StockMapper;
import br.com.marmoraria.marmoraria.modules.company.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class StockService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private StockMapper stockMapper;
    public StockDTO createStock(StockDTO stock) {
        return stockMapper.toDTO(stockRepository.save(stockMapper.toEntity(stock)));
    }

    public List<StockDTO> getAllStocks() {
        return stockRepository.findAll().stream().map(stockMapper::toDTO).toList();
    }
}
