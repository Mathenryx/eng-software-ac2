package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.dto.EmployeeDTO;
import project.model.Employee;
import project.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee create(EmployeeDTO dto) {
        Employee employee = dto.toDomain();
        if (!employee.canBeHired()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Persons cannot be hired");
        }
        return repository.save(employee);
    }

    public Employee getById(Long id) {
        return repository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        });
    }
}
