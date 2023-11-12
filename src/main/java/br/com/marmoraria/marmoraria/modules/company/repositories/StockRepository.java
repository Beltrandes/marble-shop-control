package br.com.marmoraria.marmoraria.modules.company.repositories;

import br.com.marmoraria.marmoraria.modules.company.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockRepository extends JpaRepository<Stock, UUID> {

}
