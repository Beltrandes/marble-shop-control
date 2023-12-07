package br.com.marmoraria.marmoraria.modules.company.repositories;

import br.com.marmoraria.marmoraria.modules.company.models.StockWithdrawMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StockWithdrawMovementRepository extends JpaRepository<StockWithdrawMovement, UUID> {
}
