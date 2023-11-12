package br.com.marmoraria.marmoraria.modules.company.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "stockId")
    private Stock stock;

    @JsonBackReference
    @OneToMany(mappedBy = "item")
    private List<StockMovement> movements = new ArrayList<>();
}
