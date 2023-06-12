package project.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import project.dto.EmployeeDTO;
import project.model.Employee;
import project.service.EmployeeService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShouldCreateEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO("Carlos", 25);
        Employee createdEmployee = getValidEmployee();

        when(employeeService.create(any(EmployeeDTO.class))).thenReturn(createdEmployee);

        ResponseEntity<Employee> response = employeeController.createEmployee(employeeDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(createdEmployee, response.getBody());
    }

    @Test
    public void testShouldGetEmployeeById() {
        Long employeeId = 1L;
        Employee employee = getValidEmployee();

        when(employeeService.getById(employeeId)).thenReturn(employee);

        ResponseEntity<Employee> response = employeeController.getEmployeeById(employeeId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
    }

    private Employee getValidEmployee() {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("Carlos");
        employee.setAge(25);
        employee.setType(Employee.EmploymentEnum.FULL_TIME.name());
        return employee;
    }
}
