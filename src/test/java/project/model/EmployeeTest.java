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

    @Test
    public void testShouldVerifyIfNotEquals() {
        employee = new Employee("Leticia", 23);
        employee.setId(1L);
        Employee employee2 = new Employee("Amanda", 23);
        employee2.setId(1L);

        assertFalse(employee.equals(employee2));

    }

    @Test
    public void testShouldVerifyIfEquals() {
        employee = new Employee("Leticia", 23);
        employee.setId(1L);
        employee.setType("");
        Employee employee2 = new Employee("Leticia", 23);
        employee2.setId(1L);
        employee2.setType("");

        assertTrue(employee.equals(employee2));

    }

}