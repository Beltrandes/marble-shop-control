package br.com.marmoraria.marmoraria.modules.company.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class StockWithdrawMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "stockItemId")
    private StockItem item;

    private LocalDateTime movementDate;

    private Integer initialQuantity;

    private Integer withdrawalQuantity;



}
