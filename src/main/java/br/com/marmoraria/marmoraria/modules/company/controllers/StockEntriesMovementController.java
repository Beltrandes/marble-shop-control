package br.com.marmoraria.marmoraria.modules.company.controllers;

import br.com.marmoraria.marmoraria.modules.company.dtos.AddStockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.dtos.StockEntriesMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.services.StockEntriesMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stock/movements/entries")
public class StockEntriesMovementController {

    @Autowired
    private StockEntriesMovementService stockEntriesMovementService;


    @GetMapping
    public ResponseEntity<List<StockEntriesMovementDTO>> getAll() {
        return ResponseEntity.ok().body(stockEntriesMovementService.getAllStockEntriesMovement());
    }
}
