package br.com.marmoraria.marmoraria.modules.company.controllers;

import br.com.marmoraria.marmoraria.modules.company.dtos.StockWithdrawMovementDTO;
import br.com.marmoraria.marmoraria.modules.company.services.StockWithdrawMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/stock/movements/withdraw")
public class StockWithdrawMovementController {

    @Autowired
    private StockWithdrawMovementService stockWithdrawMovementService;



    @GetMapping
    public ResponseEntity<List<StockWithdrawMovementDTO>> getAll() {
        return ResponseEntity.ok().body(stockWithdrawMovementService.getAllStockWithdrawMovements());
    }
}
