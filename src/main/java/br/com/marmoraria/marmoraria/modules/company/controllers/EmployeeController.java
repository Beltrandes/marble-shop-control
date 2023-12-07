package br.com.marmoraria.marmoraria.modules.company.controllers;

import br.com.marmoraria.marmoraria.modules.company.dtos.EmployeeDTO;
import br.com.marmoraria.marmoraria.modules.company.dtos.WithdrawStockItemDTO;
import br.com.marmoraria.marmoraria.modules.company.errors.InsufficientStockException;
import br.com.marmoraria.marmoraria.modules.company.services.EmployeeService;
import br.com.marmoraria.marmoraria.modules.company.services.StockWithdrawMovementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private StockWithdrawMovementService stockWithdrawMovementService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody EmployeeDTO employee) {
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating employee");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEmployee(@PathVariable @Valid UUID employeeId) {
        if (employeeId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Employee not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getAllEmployees());
    }

    @PutMapping("/withdraw")
    public ResponseEntity<String> withdrawStockItem(@RequestBody WithdrawStockItemDTO withdrawStockItemDTO) {
        try {
            stockWithdrawMovementService.employeeSubtractItemQuantity(withdrawStockItemDTO.stockItemId(), withdrawStockItemDTO.quantity(), withdrawStockItemDTO.employeeId());
            return ResponseEntity.ok("Item withdrawal successfully");
        } catch (InsufficientStockException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient stock available");
        }

    }



}
