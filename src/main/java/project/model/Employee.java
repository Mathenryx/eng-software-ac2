package project.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String type;

    public Employee() {
    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public boolean canBeHired() { // 2
        if (age < 16 || age > 55) { // 3
            return false; // 9
        } else if (age <= 18) { // 4
            type = EmploymentEnum.PART_TIME.name(); // 6
        } else { // 5
            type = EmploymentEnum.FULL_TIME.name(); // 7
        }
        return true; // 8
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) && name.equals(employee.name) && age.equals(employee.age) && type.equals(employee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, type);
    }

    public enum EmploymentEnum {
        PART_TIME,
        FULL_TIME
    }

}

