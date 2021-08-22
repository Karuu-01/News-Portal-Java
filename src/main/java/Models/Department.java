package Models;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String description;
    private String employee;

    public Department(String name, String description, String employee) {
        this.name = name;
        this.description = description;
        this.employee = employee;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return getId() == that.getId() && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getEmployee(), that.getEmployee());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getEmployee());
    }
}
