package br.com.marmoraria.marmoraria.modules.company.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class StockEntriesMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDateTime movementDate;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "stockItemId")
    private StockItem item;

    private Integer initialQuantity;

    private Integer addedQuantity;
}
