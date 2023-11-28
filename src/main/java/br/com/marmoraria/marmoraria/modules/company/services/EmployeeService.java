package br.com.marmoraria.marmoraria.modules.company.services;

import br.com.marmoraria.marmoraria.modules.company.dtos.EmployeeDTO;
import br.com.marmoraria.marmoraria.modules.company.mappers.EmployeeMapper;
import br.com.marmoraria.marmoraria.modules.company.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        return employeeMapper.toDTO(employeeRepository.save(employeeMapper.toEntity(employee)));
    }

    public EmployeeDTO getEmployeeById(UUID employeeId) {
        return employeeMapper.toDTO(employeeRepository.findById(employeeId).orElseThrow(null));
    }

    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeMapper::toDTO).toList();
    }
}
