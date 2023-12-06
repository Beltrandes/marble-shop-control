package br.com.marmoraria.marmoraria.modules.company.controllers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.services.StockItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/stock/item")
public class StockItemController {

    @Autowired
    private StockItemService stockItemService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody StockItemDTO itemDTO) {
        if (itemDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating stock item");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(stockItemService.createStockItem(itemDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable @Valid UUID id) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Stock Item nof found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(stockItemService.getStockItemById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @Valid UUID id) {
        stockItemService.deleteStockItem(id);
    }
}
