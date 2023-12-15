package br.com.marmoraria.marmoraria.modules.company.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String details;

    private Integer quantity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "stockId")
    private Stock stock;

    @JsonIgnore
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<StockWithdrawMovement> withdrawMovements = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<StockEntriesMovement> entriesMovements = new ArrayList<>();
}
