package project.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    private Employee employee;

    @Test
    public void testEmployeeShouldNotBeHiredWhenAgeIsLessThan16(){
        employee = new Employee("Carlos", 15);
        assertFalse(employee.canBeHired());
    }

    @Test
    public void testEmployeeShouldNotBeHiredWhenAgeIsGreaterThan55() {
        employee = new Employee("Maria", 56);
        assertFalse(employee.canBeHired());
    }

    @Test
    public void testEmployeeShouldBeHiredAsPartTimeWhenAgeIsBetween16And18(){
        employee = new Employee("Roberto", 16);
        assertTrue(employee.canBeHired());
        assertEquals(Employee.EmploymentEnum.PART_TIME.name(), employee.getType());
    }

    @Test
    public void testEmployeeShouldBeHiredAsFullTimeWhenAgeIsBetween18And55(){
        employee = new Employee("Leticia", 23);
        assertTrue(employee.canBeHired());
        assertEquals(Employee.EmploymentEnum.FULL_TIME.name(), employee.getType());
    }

}