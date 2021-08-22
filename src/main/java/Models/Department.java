package Models;

import java.util.Objects;

public class Department {

    private String name;
    private String description;
    private int employeeTag;

    public Department(String name, String description, int employeeTag) {
        this.name = name;
        this.description = description;
        this.employeeTag = employeeTag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmployeeTag() {
        return employeeTag;
    }

    public void setEmployeeTag(int employeeTag) {
        this.employeeTag = employeeTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return employeeTag == that.employeeTag && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), employeeTag);
    }
}
