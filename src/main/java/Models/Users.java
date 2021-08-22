package Models;

import java.util.Objects;

public class Users {

private int id;
private String name;
private String roles;
private String departments;

    public Users(String name, String roles, String departments) {
        this.name = name;
        this.roles =  roles;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return getId() == users.getId() && Objects.equals(getName(), users.getName()) && Objects.equals(getRoles(), users.getRoles()) && Objects.equals(getDepartments(), users.getDepartments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getRoles(), getDepartments());
    }
}


