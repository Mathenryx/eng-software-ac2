package project.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.server.ResponseStatusException;
import project.dto.EmployeeDTO;
import project.model.Employee;
import project.repository.EmployeeRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    private static Long employeeId;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldCreateEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO("Jonas", 17);
        Employee employee = new Employee("Jonas", 17);
        employee.setId(employeeId);

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee createdEmployee = employeeService.create(employeeDTO);

        verify(employeeRepository, times(1)).save(any(Employee.class));
        assertTrue(employee.equals(createdEmployee));
        assertEquals(employee.hashCode(), createdEmployee.hashCode());
    }

    @Test
    public void testShouldGetEmployeeById() {
        Employee employee = new Employee("Jonas", 17);
        employee.setId(employeeId);

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(employee));

        Employee retrievedEmployee = employeeService.getById(employeeId);

        verify(employeeRepository, times(1)).findById(employeeId);

        assertEquals(employee, retrievedEmployee);
    }

    @Test(expected = ResponseStatusException.class)
    public void testShouldFailWhenEmployeeIsUnder16() {
        EmployeeDTO employeeDTO = new EmployeeDTO("Gabriel", 10);
        employeeService.create(employeeDTO);
    }

    @Test(expected = ResponseStatusException.class)
    public void testShouldReturnEmployeeNotFound() {
        when(employeeRepository.findById(employeeId)).thenReturn(Optional.empty());

        employeeService.getById(employeeId);
    }
}

