package br.com.marmoraria.marmoraria.modules.company.repositories;

import br.com.marmoraria.marmoraria.modules.company.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
}
