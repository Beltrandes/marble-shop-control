package br.com.marmoraria.marmoraria.modules.company.repositories;

import br.com.marmoraria.marmoraria.modules.company.models.StockEntriesMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockEntriesMovementRepository extends JpaRepository<StockEntriesMovement, UUID> {
}
