package br.com.marmoraria.marmoraria.modules.company.controllers;

import br.com.marmoraria.marmoraria.modules.company.dtos.AddStockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.dtos.StockDTO;
import br.com.marmoraria.marmoraria.modules.company.services.StockEntriesMovementService;
import br.com.marmoraria.marmoraria.modules.company.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockEntriesMovementService stockEntriesMovementService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody StockDTO stock) {
        if (stock == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating stock");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(stockService.createStock(stock));
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> getStocks() {
        return ResponseEntity.ok().body(stockService.getAllStocks());
    }

    @PutMapping("/add")
    public ResponseEntity<String> addStockItemQuantity(@RequestBody AddStockItemDTO addStockItemDTO) {
        try {
            stockEntriesMovementService.addStockItemQuantity(addStockItemDTO.stockItemId(), addStockItemDTO.quantity());
            return ResponseEntity.ok().body("Stock item quantity successfully added!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
