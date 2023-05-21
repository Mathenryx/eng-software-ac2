package project.model;

public class Employee {
    private final String name;
    private final Integer age;
    private String type;

    public Employee(String name, int age) { // 1
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

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public enum EmploymentEnum {
        PART_TIME,
        FULL_TIME
    }

}

