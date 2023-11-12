package br.com.marmoraria.marmoraria.modules.company.controllers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockDTO;
import br.com.marmoraria.marmoraria.modules.company.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody StockDTO stock) {
        if (stock == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating stock");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(stockService.createStock(stock));
    }
}
