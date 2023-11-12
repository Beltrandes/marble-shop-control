package br.com.marmoraria.marmoraria.modules.company.repositories;

import br.com.marmoraria.marmoraria.modules.company.models.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockMovementRepository extends JpaRepository<StockMovement, UUID> {
}
