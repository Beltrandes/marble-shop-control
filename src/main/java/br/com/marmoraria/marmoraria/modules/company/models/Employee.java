package br.com.marmoraria.marmoraria.modules.company.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<StockWithdrawMovement> movements = new ArrayList<>();


}
