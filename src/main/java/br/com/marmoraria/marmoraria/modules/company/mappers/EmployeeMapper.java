package br.com.marmoraria.marmoraria.modules.company.mappers;

import br.com.marmoraria.marmoraria.modules.company.dtos.EmployeeDTO;
import br.com.marmoraria.marmoraria.modules.company.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getName(), employee.getMovements());
    }

    public Employee toEntity(EmployeeDTO employeeDTO) {
        var employee = new Employee();

        employee.setId(employeeDTO.id());
        employee.setName(employeeDTO.name());
        employee.setMovements(employeeDTO.movements());

        return employee;
    }
}
