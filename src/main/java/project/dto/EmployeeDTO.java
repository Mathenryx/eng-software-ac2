package project.dto;

import project.model.Employee;

public class EmployeeDTO {

    private String name;
    private Integer age;

    public EmployeeDTO(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public EmployeeDTO() {
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }


    public Employee toDomain() {
        return new Employee(this.name, this. age);
    }
}
